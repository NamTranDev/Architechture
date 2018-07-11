package nam.tran.architechture.view;

import android.content.Intent;

import javax.inject.Inject;
import javax.inject.Singleton;

import nam.tran.architechture.view.main.MainActivity;
import nam.tran.architechture.view.main.activity.TestTempleteActivity;
import nam.tran.architechture.view.main.activity.season.SoccerSeasonFragment;
import nam.tran.architechture.view.main.activity.team.TeamActivity;
import nam.tran.architechture.view.main.fragment.TestFragmentTempleteActivity;
import tran.nam.core.Navigator;
import tran.nam.core.view.BaseActivity;
import tran.nam.util.Constant;

@SuppressWarnings("WeakerAccess")
@Singleton
public class NavigatorApp extends Navigator {

    @Inject
    NavigatorApp() {
        super();
    }

    public void goToTestTempleteActivity(BaseActivity activity) {
        activity.startActivity(new Intent(activity, TestTempleteActivity.class));
        animationTransition(activity);
    }

    public void goToTeamActivity(BaseActivity activity, int id) {
        Intent intent = new Intent(activity, TeamActivity.class);
        intent.putExtra(Constant.KEY_INTENT.ID_SEASON,id);
        activity.startActivity(intent);
        animationTransition(activity);
    }

    public void goToTestFragmentTemplete(BaseActivity activity) {
        activity.startActivity(new Intent(activity, TestFragmentTempleteActivity.class));
        animationTransition(activity);
    }
}
