package ${packageName}.${funtionName};

import android.os.Bundle;

import ${applicationPackage}.R;
<#if hasInject>
import tran.nam.core.view.BaseActivityInjection;
import ${packageName}.view.NavigatorApp;
<#else>
import tran.nam.core.view.BaseActivity;
</#if>

<#if hasBiding>
import android.databinding.DataBindingUtil;
import ${applicationPackage}.databinding.Activity${Name}Binding;
</#if>

public class ${activityName} extends <#if hasInject>BaseActivityInjection<NavigatorApp><#else>BaseActivity</#if>{

    <#if hasBiding>
    private Activity${underscoreToCamelCase(classToResource(activityName))}Binding mViewDataBinding;
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

    <#if hasStatusBar>
    @Override
    protected void setStatusBar() {

    }
    </#if>
}
