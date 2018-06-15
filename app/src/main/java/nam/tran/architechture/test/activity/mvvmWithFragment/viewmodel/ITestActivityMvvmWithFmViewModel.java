package nam.tran.architechture.test.activity.mvvmWithFragment.viewmodel;

import java.util.List;

import nam.tran.architechture.model.TeamModel;
import tran.nam.core.viewmodel.IViewModel;

public interface ITestActivityMvvmWithFmViewModel extends IViewModel {
    void updateData(List<TeamModel> data);

    void updateView();
}