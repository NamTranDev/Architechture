package nam.tran.architechture.view.main.activity;

import android.os.Bundle;

import nam.tran.architechture.R;
import nam.tran.architechture.view.NavigatorApp;
import nam.tran.architechture.view.main.activity.season.SoccerSeasonFragment;
import tran.nam.core.view.BaseActivityWithFragment;
import tran.nam.core.view.BaseFragment;

import android.databinding.DataBindingUtil;

import nam.tran.architechture.databinding.ActivityTestTempleteBinding;

public class TestTempleteActivity extends BaseActivityWithFragment<NavigatorApp> {

    private ActivityTestTempleteBinding mViewDataBinding;

    @Override
    public int getLayoutId() {
        return R.layout.activity_test_templete;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        mViewDataBinding = DataBindingUtil.setContentView(this, getLayoutId());
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
        return R.id.test_templete_contain;
    }

}
