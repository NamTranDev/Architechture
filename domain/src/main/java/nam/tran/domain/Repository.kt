package nam.tran.domain

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Transformations
import nam.tran.domain.entity.SoccerSeasonEntity
import nam.tran.domain.entity.TeamEntity
import nam.tran.domain.entity.state.Loading.LOADING_NORMAL
import nam.tran.domain.entity.state.Resource
import nam.tran.domain.executor.AppExecutors
import nam.tran.domain.interactor.core.DataBoundResource
import nam.tran.domain.mapper.DataEntityMapper
import nam.tran.flatform.IApi
import nam.tran.flatform.core.ApiResponse
import nam.tran.flatform.database.DbProvider
import nam.tran.flatform.local.IPreference
import nam.tran.flatform.model.response.session.SoccerSeason
import nam.tran.flatform.model.response.team.ListTeamResponse
import javax.inject.Inject

@Suppress("unused")
class Repository @Inject
internal constructor(private val appExecutors: AppExecutors, private val iPreference: IPreference, private val dataEntityMapper: DataEntityMapper, private val iApi: IApi, private val dbProvider: DbProvider) : IRepository {

    override val listSeason: LiveData<Resource<List<SoccerSeasonEntity>>>
        get() = object : DataBoundResource<List<SoccerSeasonEntity>, List<SoccerSeason>>(appExecutors) {
            override fun saveCallResult(item: List<SoccerSeason>) {
                dbProvider.beginTransaction()
                try {
                    dbProvider.soccerSeasonDao().insert(item)
                    dbProvider.setTransactionSuccessful()
                } finally {
                    dbProvider.endTransaction()
                }
            }

            override fun shouldFetch(data: List<SoccerSeasonEntity>?): Boolean {
                return data == null || data.isEmpty()
            }

            override fun loadFromDb(): LiveData<List<SoccerSeasonEntity>> {
                return Transformations.switchMap(dbProvider.soccerSeasonDao().fetchSoccerSeason()) { `object` ->
                    val data = MutableLiveData<List<SoccerSeasonEntity>>()
                    data.value = dataEntityMapper.mSoccerSeasonEntityDataMapper.transform(`object`)
                    data
                }
            }

            override fun createCall(): LiveData<ApiResponse<List<SoccerSeason>>> {
                return iApi.listSeason
            }

            override fun statusLoading(): Int {
                return LOADING_NORMAL
            }
        }.asLiveData()

    override fun getListTeam(idSeason: Int, type: Int): LiveData<Resource<List<TeamEntity>>> {
        return object : DataBoundResource<List<TeamEntity>, ListTeamResponse>(appExecutors) {
            override fun saveCallResult(item: ListTeamResponse) {
                for (team in item.teams!!) {
                    team.idSeason = idSeason
                }
                dbProvider.beginTransaction()
                try {
                    dbProvider.teamDao().insert(item.teams!!)
                    dbProvider.setTransactionSuccessful()
                } finally {
                    dbProvider.endTransaction()
                }
            }

            override fun shouldFetch(data: List<TeamEntity>?): Boolean {
                return data == null || data.isEmpty()
            }

            override fun loadFromDb(): LiveData<List<TeamEntity>> {
                return Transformations.switchMap(dbProvider.teamDao().fetchTeams(idSeason)) { input ->
                    val data = MutableLiveData<List<TeamEntity>>()
                    data.value = dataEntityMapper.mTeamEntityDataMapper.transform(input)
                    data
                }
            }

            override fun createCall(): LiveData<ApiResponse<ListTeamResponse>> {
                return iApi.getListTeam(idSeason)
            }

            override fun statusLoading(): Int {
                return type
            }
        }.asLiveData()
    }
}
