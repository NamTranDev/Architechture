package ${packageName}.view.${funtionName};

import android.os.Bundle;

import ${packageName}.R;
import tran.nam.core.view.BaseActivityWithFragment;
import tran.nam.core.view.BaseFragment;

import ${packageName}.view.NavigatorApp;

import android.databinding.DataBindingUtil;
import ${packageName}.databinding.Activity${Name}Binding;

public class ${activityName} extends BaseActivityWithFragment<NavigatorApp> {

    private Activity${Name}Binding mViewDataBinding;

    @Override
    public int getLayoutId() {
        return R.layout.${layoutName};
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        mViewDataBinding = DataBindingUtil.setContentView(this, getLayoutId());
        mViewDataBinding.setView(this);
    }

    @Override
    public void initData(Bundle savedInstanceState) {

    }

    @Override
    public BaseFragment[] getFragments() {
        return new BaseFragment[]{};
    }

    @Override
    public int getContentLayoutId() {
        return R.id.${layoutName?replace('activity_', '')}_contain;
    }

    <#if hasStatusBar>
    @Override
    protected void setStatusBar() {

    }
    </#if>
}
