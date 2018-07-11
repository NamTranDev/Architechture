package nam.tran.architechture.view.main.fragment.parent.season.viewmodel;

import android.app.Application;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import java.util.List;

import javax.inject.Inject;

import nam.tran.architechture.mapper.DataMapper;
import nam.tran.architechture.model.SoccerSeasonModel;
import nam.tran.architechture.model.TeamModel;
import nam.tran.domain.entity.state.Loading;
import nam.tran.domain.entity.state.Resource;
import nam.tran.domain.interactor.usecase.ISoccerSeasonUseCase;
import nam.tran.domain.interactor.usecase.ITeamUseCase;
import tran.nam.core.viewmodel.BaseFragmentViewModel;
import tran.nam.core.viewmodel.IProgressViewModel;

public class SoccerSeasonChildViewModel extends BaseFragmentViewModel<ISoccerSeasonChildViewModel> implements IProgressViewModel {

    private final ISoccerSeasonUseCase iSoccerSeasonUseCase;
    private final DataMapper mDataMapper;
    private final ITeamUseCase iTeamUseCase;

    private MutableLiveData<Resource<List<SoccerSeasonModel>>> results = new MutableLiveData<>();
    private MutableLiveData<Resource<List<TeamModel>>> teamResults = null;

    @Inject
    SoccerSeasonChildViewModel(@NonNull Application application, ISoccerSeasonUseCase iSoccerSeasonUseCase, ITeamUseCase iTeamUseCase, DataMapper mDataMapper) {
        super(application);
        this.iSoccerSeasonUseCase = iSoccerSeasonUseCase;
        this.iTeamUseCase = iTeamUseCase;
        this.mDataMapper = mDataMapper;
    }

    @Override
    public void onInitialized() {
        ISoccerSeasonChildViewModel view = view();
        if (view != null) {
            getSoccerSeason(view).observe(view, listResource -> {
                view.updateView();
                if (listResource != null && listResource.data != null && listResource.data.size() > 0) {
                    view.updateData(listResource.data);
                }
            });
        }
    }

    private MutableLiveData<Resource<List<SoccerSeasonModel>>> getSoccerSeason(ISoccerSeasonChildViewModel view) {
        iSoccerSeasonUseCase.getSoccerSeasonData().observe(view, listResource -> {
                    results.setValue(mDataMapper.soccerSeasonModelDataMapper.transform(listResource));
                }
        );

        return results;
    }

    public void getTeamFollowSeason(int idSeason){
        if (teamResults == null)
            teamResults = new MutableLiveData<>();
        ISoccerSeasonChildViewModel view = view();
        if (view != null){
            getTeams(idSeason,view).observe(view, listResource -> {
                view.updateView();
                if (listResource != null && listResource.data != null && listResource.data.size() > 0) {
                    view.getTeamsData(listResource.data);
                }
            });
        }
    }

    private MutableLiveData<Resource<List<TeamModel>>> getTeams(int idSeason,ISoccerSeasonChildViewModel view){
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
