package nam.tran.domain;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Transformations;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.List;

import javax.inject.Inject;

import nam.tran.domain.entity.SoccerSeasonEntity;
import nam.tran.domain.entity.TeamEntity;
import nam.tran.domain.entity.state.Resource;
import nam.tran.domain.executor.AppExecutors;
import nam.tran.domain.interactor.core.DataBoundResource;
import nam.tran.domain.mapper.DataEntityMapper;
import nam.tran.flatform.IApi;
import nam.tran.flatform.core.ApiResponse;
import nam.tran.flatform.database.DbProvider;
import nam.tran.flatform.local.IPreference;
import nam.tran.flatform.model.response.session.SoccerSeason;
import nam.tran.flatform.model.response.team.ListTeamResponse;
import nam.tran.flatform.model.response.team.Team;

import static nam.tran.domain.entity.state.Loading.LOADING_NORMAL;

@SuppressWarnings({"FieldCanBeLocal", "unused"})
public class Repository implements IRepository {

    private final AppExecutors appExecutors;
    private final IPreference iPreference;
    private final DataEntityMapper dataEntityMapper;
    private final IApi iApi;
    private final DbProvider dbProvider;

    @Inject
    Repository(AppExecutors appExecutors, IPreference iPreference, DataEntityMapper dataEntityMapper, IApi iApi, DbProvider dbProvider) {
        this.appExecutors = appExecutors;
        this.iPreference = iPreference;
        this.dataEntityMapper = dataEntityMapper;
        this.iApi = iApi;
        this.dbProvider = dbProvider;
    }

    @Override
    public LiveData<Resource<List<SoccerSeasonEntity>>> getListSeason() {
        return new DataBoundResource<List<SoccerSeasonEntity>, List<SoccerSeason>>(appExecutors) {
            @Override
            protected void saveCallResult(@NonNull List<SoccerSeason> item) {
                dbProvider.beginTransaction();
                try {
                    dbProvider.soccerSeasonDao().insert(item);
                    dbProvider.setTransactionSuccessful();
                } finally {
                    dbProvider.endTransaction();
                }
            }

            @Override
            protected boolean shouldFetch(@Nullable List<SoccerSeasonEntity> data) {
                return data == null || data.isEmpty();
            }

            @NonNull
            @Override
            protected LiveData<List<SoccerSeasonEntity>> loadFromDb() {
                return Transformations.switchMap(dbProvider.soccerSeasonDao().fetchSoccerSeason(), object -> {
                    MutableLiveData<List<SoccerSeasonEntity>> data = new MutableLiveData<>();
                    data.setValue(dataEntityMapper.mSoccerSeasonEntityDataMapper.transform(object));
                    return data;
                });
            }

            @NonNull
            @Override
            protected LiveData<ApiResponse<List<SoccerSeason>>> createCall() {
                return iApi.getListSeason();
            }

            @Override
            protected int statusLoading() {
                return LOADING_NORMAL;
            }
        }.asLiveData();
    }

    @Override
    public LiveData<Resource<List<TeamEntity>>> getListTeam(int idSeason, int type) {
        return new DataBoundResource<List<TeamEntity>, ListTeamResponse>(appExecutors) {
            @Override
            protected void saveCallResult(@NonNull ListTeamResponse item) {
                for (Team team : item.getTeams()){
                    team.idSeason = idSeason;
                }
                dbProvider.beginTransaction();
                try {
                    dbProvider.teamDao().insert(item.getTeams());
                    dbProvider.setTransactionSuccessful();
                } finally {
                    dbProvider.endTransaction();
                }
            }

            @Override
            protected boolean shouldFetch(@Nullable List<TeamEntity> data) {
                return data == null || data.isEmpty();
            }

            @NonNull
            @Override
            protected LiveData<List<TeamEntity>> loadFromDb() {
                return Transformations.switchMap(dbProvider.teamDao().fetchTeams(idSeason), input -> {
                    MutableLiveData<List<TeamEntity>> data = new MutableLiveData<>();
                    data.setValue(dataEntityMapper.mTeamEntityDataMapper.transform(input));
                    return data;
                });
            }

            @NonNull
            @Override
            protected LiveData<ApiResponse<ListTeamResponse>> createCall() {
                return iApi.getListTeam(idSeason);
            }

            @Override
            protected int statusLoading() {
                return type;
            }
        }.asLiveData();
    }
}
