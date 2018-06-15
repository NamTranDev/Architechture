package nam.tran.architechture.test.activity.mvvm.viewmodel;

import java.util.List;

import nam.tran.architechture.model.SoccerSeasonModel;
import nam.tran.architechture.model.TeamModel;
import tran.nam.core.viewmodel.IViewModel;

public interface ITestActivityMvvmViewModel extends IViewModel {

    void updateData(List<SoccerSeasonModel> data);

    void updateView();

    void getTeams(List<TeamModel> data);
}