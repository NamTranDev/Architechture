package nam.tran.architechture.view.main;

import android.os.Bundle;

import nam.tran.architechture.R;
import nam.tran.architechture.view.NavigatorApp;
import tran.nam.core.view.BaseActivityInjection;

import android.databinding.DataBindingUtil;

import javax.inject.Inject;

import nam.tran.architechture.databinding.ActivityMainBinding;

public class MainActivity extends BaseActivityInjection<NavigatorApp> {

    private ActivityMainBinding mViewDataBinding;

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        mViewDataBinding = DataBindingUtil.setContentView(this, getLayoutId());
        mViewDataBinding.setView(this);
    }

    @Override
    public void initData(Bundle savedInstanceState) {

    }

    public void onActivityClick(){
        mNavigator.goToTestTempleteActivity(this);
    }

    public void onFragmentClick(){
        mNavigator.goToTestFragmentTemplete(this);
    }
}
