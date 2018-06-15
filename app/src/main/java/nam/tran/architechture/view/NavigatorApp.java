package nam.tran.architechture.view;

import android.content.Intent;

import javax.inject.Inject;
import javax.inject.Singleton;

import nam.tran.architechture.test.activity.mvvm.TestActivityMvvm;
import nam.tran.architechture.test.activity.mvvmWithFragment.TestActivityMvvmWithFM;
import nam.tran.architechture.test.activity.withFragment.TestActivityWithFragment;
import tran.nam.core.Navigator;
import tran.nam.core.view.BaseActivity;
import tran.nam.util.Constant;

@SuppressWarnings("WeakerAccess")
@Singleton
public class NavigatorApp extends Navigator {

    @Inject
    NavigatorApp() {
    }

    public void goToActivityWithFragment(BaseActivity activity) {
        activity.startActivity(new Intent(activity, TestActivityWithFragment.class));
        animationTransition(activity);
    }

    public void goToActivityMvvm(BaseActivity activity) {
        activity.startActivity(new Intent(activity, TestActivityMvvm.class));
        animationTransition(activity);
    }

    public void goToActivityMvvmWithFragment(BaseActivity baseActivity, int idSeason) {
        Intent intent = new Intent(baseActivity, TestActivityMvvmWithFM.class);
        intent.putExtra(Constant.KEY_INTENT.ID_SEASON, idSeason);
        baseActivity.startActivity(intent);
    }
}
