package nam.tran.architechture.view.main.fragment.parent.season.viewmodel;


import java.util.List;

import nam.tran.architechture.model.SoccerSeasonModel;
import nam.tran.architechture.model.TeamModel;
import nam.tran.architechture.view.main.activity.season.adapter.SoccerSeasonAdapter;
import nam.tran.architechture.view.main.fragment.parent.season.adapter.SoccerSeasonChildAdapter;
import tran.nam.core.viewmodel.IViewModel;

public interface ISoccerSeasonChildViewModel extends IViewModel,SoccerSeasonChildAdapter.OnItemSoccerSeasonClick {
    void updateData(List<SoccerSeasonModel> data);

    void getTeamsData(List<TeamModel> data);

    void updateView();
}