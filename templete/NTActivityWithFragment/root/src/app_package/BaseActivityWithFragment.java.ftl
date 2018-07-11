package ${packageName}.${funtionName};

import android.os.Bundle;

import ${applicationPackage}.R;
import tran.nam.core.view.BaseActivityWithFragment;
import tran.nam.core.view.BaseFragment;

import ${packageName}.view.NavigatorApp;

<#if hasBiding>
import android.databinding.DataBindingUtil;
import ${applicationPackage}.databinding.Activity${Name}Binding;
</#if>

public class ${activityName} extends BaseActivityWithFragment<NavigatorApp> {

    <#if hasBiding>
    private Activity${Name}Binding mViewDataBinding;
    </#if>

    @Override
    public int getLayoutId() {
        return R.layout.${layoutName};
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        <#if hasBiding>mViewDataBinding = DataBindingUtil.setContentView(this, getLayoutId());
        mViewDataBinding.setView(this);</#if>
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
