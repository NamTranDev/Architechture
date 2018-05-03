package nam.tran.architechture.application.viewmodel;

import android.app.Application;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import java.util.List;

import javax.inject.Inject;

import nam.tran.architechture.application.model.SoccerSeasonModel;
import nam.tran.architechture.mapper.DataMapper;
import nam.tran.domain.entity.state.Resource;
import nam.tran.domain.interactor.usecase.ISoccerSeasonUseCase;
import tran.nam.core.viewmodel.BaseFragmentViewModel;

public class SoccerSeasonViewModel extends BaseFragmentViewModel<ISoccerSeasonViewModel, List<SoccerSeasonModel>> {

    private final ISoccerSeasonUseCase iSoccerSeasonUseCase;
    private final DataMapper mDataMapper;

    @Inject
    SoccerSeasonViewModel(@NonNull Application application, ISoccerSeasonUseCase iSoccerSeasonUseCase, DataMapper mDataMapper) {
        super(application);
        this.iSoccerSeasonUseCase = iSoccerSeasonUseCase;
        this.mDataMapper = mDataMapper;
    }

    @Override
    public void onInitialized() {
        ISoccerSeasonViewModel view = view();
        if (view != null) {
            getSoccerSeason(view).observe(view, listResource -> {
                if (listResource != null && listResource.data != null && listResource.data.size() > 0) {
                    view.updateData(listResource.data);
                }
                view.updateView();
            });
        }
    }

    private MutableLiveData<Resource<List<SoccerSeasonModel>>> getSoccerSeason(ISoccerSeasonViewModel view) {
        if (results != null) {
            // TODO: 2017/11/16 Memory Cache
            return results;
        } else {
            results = new MutableLiveData<>();
        }

        iSoccerSeasonUseCase.getSoccerSeasonData().observe(view, listResource -> {
                    results.setValue(mDataMapper.soccerSeasonModelDataMapper.transform(listResource));
                }
        );

        return results;
    }
}
