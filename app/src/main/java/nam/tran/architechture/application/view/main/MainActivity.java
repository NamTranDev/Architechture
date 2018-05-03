package nam.tran.architechture.application.view.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import nam.tran.architechture.R;
import tran.nam.core.view.BaseActivityWithFragment;
import tran.nam.core.view.BaseFragment;

public class MainActivity extends BaseActivityWithFragment {

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void setStatusBar() {

    }

    @Override
    public void initView(Bundle savedInstanceState) {

    }

    @Override
    public void initData(Bundle savedInstanceState) {

    }

    @Override
    public BaseFragment[] getFragments() {
        return new BaseFragment[]{SoccerSeasonFragment.getInstance()};
    }

    @Override
    public int getContentLayoutId() {
        return R.id.main_contain;
    }
}
