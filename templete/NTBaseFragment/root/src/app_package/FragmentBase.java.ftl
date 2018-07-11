package ${packageName}.${funtionName};

<#if hasArgument>
import android.os.Bundle;
</#if>

import ${applicationPackage}.R;

<#if hasBiding>
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import tran.nam.common.AutoClearedValue;

import android.databinding.DataBindingUtil;
import ${applicationPackage}.databinding.Fragment${Name}Binding;
</#if>

<#if hasInject>
import tran.nam.core.view.BaseFragmentInjection;
import ${packageName}.view.NavigatorApp;
<#else>
import tran.nam.core.view.BaseFragment;
</#if>

public class ${fragmentName} extends <#if hasInject>BaseFragmentInjection<NavigatorApp><#else>BaseFragment</#if>{

    <#if hasBiding>
    private Fragment${Name}Binding mViewDataBinding;
    private AutoClearedValue<Fragment${Name}Binding> binding;
    </#if>

    public static ${fragmentName} getInstance() {
        <#if hasArgument>
        ${fragmentName} fragment = new ${fragmentName}();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        return fragment;
        <#else>
        return new ${fragmentName}();
        </#if>
    }

    @Override
    public int getLayoutId() {
        return R.layout.${layoutName};
    }

    <#if hasBiding>
    @Override
    public View initLayout(@NonNull LayoutInflater inflater, @Nullable ViewGroup container) {
        mViewDataBinding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false);
        binding = new AutoClearedValue<>(this,mViewDataBinding);
        return mViewDataBinding.getRoot();
    }
    </#if>

    @Override
    protected void onVisible() {
        <#if hasArgument>
        if (getArguments() != null) {
            
        }
        </#if>
    }
}
