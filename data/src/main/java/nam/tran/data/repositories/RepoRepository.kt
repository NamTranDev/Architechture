package nam.tran.data.repositories

import io.reactivex.Single
import nam.tran.data.database.DbProvider
import nam.tran.data.local.IPreference
import nam.tran.data.mapper.RepositoryMapper
import nam.tran.data.network.IApi
import nam.tran.domain.entities.RepositoryEntity
import nam.tran.domain.repositories.IRepoRepository
import javax.inject.Inject

class RepoRepository @Inject constructor(private val iPreference: IPreference, private val iApi: IApi
                                         , private val iDbProvider: DbProvider) : IRepoRepository {
    override fun getRepositories(page: Int, perPage: Int): Single<List<RepositoryEntity>> {
        return iApi.getRepositories(iPreference.user, page, perPage).map {
            val mapper = RepositoryMapper()
            mapper.mapFrom(it)
        }
    }
}