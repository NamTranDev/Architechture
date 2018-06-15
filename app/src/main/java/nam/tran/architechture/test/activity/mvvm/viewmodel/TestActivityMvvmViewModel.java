package nam.tran.architechture.test.activity.mvvm.viewmodel;

import android.app.Application;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.List;

import javax.inject.Inject;

import nam.tran.architechture.mapper.DataMapper;
import nam.tran.architechture.model.SoccerSeasonModel;
import nam.tran.architechture.model.TeamModel;
import nam.tran.domain.entity.TeamEntity;
import nam.tran.domain.entity.state.Loading;
import nam.tran.domain.entity.state.Resource;
import nam.tran.domain.interactor.usecase.ISoccerSeasonUseCase;
import nam.tran.domain.interactor.usecase.ITeamUseCase;
import tran.nam.core.viewmodel.BaseActivityViewModel;
import tran.nam.core.viewmodel.IProgressViewModel;

public class TestActivityMvvmViewModel extends BaseActivityViewModel<ITestActivityMvvmViewModel> implements IProgressViewModel {

    private final ISoccerSeasonUseCase iSoccerSeasonUseCase;
    private final ITeamUseCase iTeamUseCase;
    private final DataMapper mDataMapper;

    private MutableLiveData<Resource<List<SoccerSeasonModel>>> results = new MutableLiveData<>();
    private MutableLiveData<Resource<List<TeamModel>>> teamResults = null;

    @Inject
    TestActivityMvvmViewModel(@NonNull Application application, ISoccerSeasonUseCase iSoccerSeasonUseCase, ITeamUseCase iTeamUseCase, DataMapper mDataMapper) {
        super(application);
        this.iSoccerSeasonUseCase = iSoccerSeasonUseCase;
        this.iTeamUseCase = iTeamUseCase;
        this.mDataMapper = mDataMapper;
    }

    @Override
    public void onCreated(@NonNull ITestActivityMvvmViewModel view) {
        super.onCreated(view);
        getSoccerSeason(view).observe(view, listResource -> {
            if (listResource != null && listResource.data != null && listResource.data.size() > 0) {
                view.updateData(listResource.data);
            }
            view.updateView();
        });
    }

    public void getTeamFollowSeason(int idSeason){
        if (teamResults == null)
            teamResults = new MutableLiveData<>();
        ITestActivityMvvmViewModel view = view();
        if (view != null){
            getTeams(idSeason,view).observe(view, listResource -> {
                if (listResource != null && listResource.data != null && listResource.data.size() > 0) {
                    view.getTeams(listResource.data);
                }
                view.updateView();
            });
        }
    }

    private MutableLiveData<Resource<List<SoccerSeasonModel>>> getSoccerSeason(ITestActivityMvvmViewModel view) {
        iSoccerSeasonUseCase.getSoccerSeasonData().observe(view, listResource ->
                results.setValue(mDataMapper.soccerSeasonModelDataMapper.transform(listResource))
        );

        return results;
    }

    private MutableLiveData<Resource<List<TeamModel>>> getTeams(int idSeason,ITestActivityMvvmViewModel view){
        iTeamUseCase.getTeamData(idSeason, Loading.LOADING_DIALOG).observe(view, listResource ->
                teamResults.setValue(mDataMapper.teamModelDataMapper.transform(listResource)));
        return teamResults;
    }

    @Override
    public Resource getResource() {
        if (teamResults == null)
            return results.getValue();
        return teamResults.getValue();
    }
}
