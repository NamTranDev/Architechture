package nam.tran.architechture.test.activity.baseActivity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;

import javax.inject.Inject;

import nam.tran.architechture.R;
import nam.tran.architechture.databinding.ActivityTestActivityBaseBinding;
import nam.tran.architechture.view.NavigatorApp;
import tran.nam.core.view.BaseActivity;

public class TestActivityBase extends BaseActivity {

    @Inject
    NavigatorApp mNavigator;

    private ActivityTestActivityBaseBinding mViewDataBinding;

    @Override
    public int getLayoutId() {
        return R.layout.activity_test_activity_base;
    }

    @Override
    protected void initLayout() {
        mViewDataBinding = DataBindingUtil.setContentView(this, getLayoutId());
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        mViewDataBinding.tvActivityWithFragmentTest.setOnClickListener(v -> {
            mNavigator.goToActivityWithFragment(this);
        });
        mViewDataBinding.tvFinish.setOnClickListener(v -> mNavigator.exit(TestActivityBase.this));
    }

    @Override
    public void initData(Bundle savedInstanceState) {

    }

}
