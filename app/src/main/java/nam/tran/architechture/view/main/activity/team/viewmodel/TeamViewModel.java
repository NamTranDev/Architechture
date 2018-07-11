package nam.tran.architechture.view.main.activity.team.viewmodel;

import android.app.Application;
import android.support.annotation.NonNull;

import javax.inject.Inject;

import nam.tran.architechture.mapper.DataMapper;
import nam.tran.architechture.model.TeamModel;
import nam.tran.domain.entity.state.Loading;
import nam.tran.domain.interactor.usecase.ITeamUseCase;
import tran.nam.core.viewmodel.BaseActivityViewModel;
import tran.nam.core.viewmodel.IProgressViewModel;
import nam.tran.domain.entity.state.Resource;

import android.arch.lifecycle.MutableLiveData;

import java.util.List;

public class TeamViewModel extends BaseActivityViewModel<ITeamViewModel> implements IProgressViewModel {

    private MutableLiveData<Resource<List<TeamModel>>> results = new MutableLiveData<>();

    private final ITeamUseCase iTeamUseCase;
    private final DataMapper mDataMapper;

    @Inject
    TeamViewModel(@NonNull Application application, ITeamUseCase iTeamUseCase, DataMapper mDataMapper) {
        super(application);
        this.iTeamUseCase = iTeamUseCase;
        this.mDataMapper = mDataMapper;
    }

    @Override
    public Resource getResource() {
        return results.getValue();
    }

    @Override
    public void onCreated(@NonNull ITeamViewModel view) {
        super.onCreated(view);
        getTeams(view,view.getIdSeasonSoccer()).observe(view, listResource -> {
            if (listResource != null && listResource.data != null && listResource.data.size() > 0) {
                view.updateData(listResource.data);
            }
            view.updateView();
        });
    }

    private MutableLiveData<Resource<List<TeamModel>>> getTeams(ITeamViewModel view,int idSeason){
        iTeamUseCase.getTeamData(idSeason, Loading.LOADING_NORMAL).observe(view, listResource ->
                results.setValue(mDataMapper.teamModelDataMapper.transform(listResource)));
        return results;
    }
}
