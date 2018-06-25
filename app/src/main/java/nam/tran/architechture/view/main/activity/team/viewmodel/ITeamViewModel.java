package nam.tran.architechture.view.main.activity.team.viewmodel;

import java.util.List;

import nam.tran.architechture.model.TeamModel;
import tran.nam.core.viewmodel.IViewModel;

public interface ITeamViewModel extends IViewModel {
    void updateView();

    void updateData(List<TeamModel> data);

    int getIdSeasonSoccer();
}