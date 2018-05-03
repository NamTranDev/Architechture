package nam.tran.architechture.application.viewmodel;

import java.util.List;

import nam.tran.architechture.application.model.SoccerSeasonModel;
import nam.tran.architechture.application.view.adapter.SoccerSeasonAdapter;
import tran.nam.core.viewmodel.IViewModel;

public interface ISoccerSeasonViewModel extends IViewModel,SoccerSeasonAdapter.OnItemSoccerSeasonClick {
    void updateData(List<SoccerSeasonModel> data);

    void updateView();
}
