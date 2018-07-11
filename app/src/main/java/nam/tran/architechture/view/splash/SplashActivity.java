package nam.tran.architechture.view.splash;

import android.content.Intent;
import android.os.Bundle;

import nam.tran.architechture.R;
import nam.tran.architechture.view.main.MainActivity;
import tran.nam.core.view.BaseActivity;

import android.databinding.DataBindingUtil;
import android.os.Handler;

import nam.tran.architechture.databinding.ActivitySplashBinding;

public class SplashActivity extends BaseActivity {

    private ActivitySplashBinding mViewDataBinding;
    private Handler handler;
    private Runnable runnable = () -> {
        startActivity(new Intent(this, MainActivity.class));
        finish();
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
        super.onDestroy();
        handler.removeCallbacks(runnable);
        handler = null;
        runnable = null;
    }
}
