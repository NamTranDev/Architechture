package nam.tran.architechture.view.season.viewmodel;


import java.util.List;

import nam.tran.architechture.model.SoccerSeasonModel;
import nam.tran.architechture.view.season.adapter.SoccerSeasonAdapter;
import tran.nam.core.viewmodel.IViewModel;

public interface ISoccerSeasonViewModel extends IViewModel,SoccerSeasonAdapter.OnItemSoccerSeasonClick {
    void updateData(List<SoccerSeasonModel> data);

    void updateView();
}