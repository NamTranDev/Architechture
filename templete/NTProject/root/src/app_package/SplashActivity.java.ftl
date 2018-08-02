package ${packageName}.view.splash;

import android.content.Intent;
import android.os.Bundle;

import ${packageName}.R;
import tran.nam.core.view.BaseActivityInjection;
import ${packageName}.view.NavigatorApp;

import android.databinding.DataBindingUtil;
import android.os.Handler;

import ${packageName}.databinding.ActivitySplashBinding;

public class SplashActivity extends BaseActivityInjection<NavigatorApp> {

    private ActivitySplashBinding mViewDataBinding;
    private Handler handler;
    private Runnable runnable = () -> {
        
    };

    @Override
    public int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        mViewDataBinding = DataBindingUtil.setContentView(this, getLayoutId());
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        handler = new Handler();
        handler.postDelayed(runnable,3000);
    }

    @Override
    protected void onDestroy() {
        handler.removeCallbacks(runnable);
        handler = null;
        runnable = null;
        super.onDestroy();
    }
}
