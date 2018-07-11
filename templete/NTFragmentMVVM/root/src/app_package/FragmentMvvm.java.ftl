package ${packageName}.${funtionName};

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
<#if hasArgument>
import android.os.Bundle;
</#if>

import ${packageName}.${funtionName}.viewmodel.I${Name}ViewModel;
import ${packageName}.${funtionName}.viewmodel.${Name}ViewModel;

import ${applicationPackage}.R;
import ${applicationPackage}.databinding.Fragment${Name}Binding;

import tran.nam.core.view.mvvm.BaseFragmentMVVM;

public class ${fragmentName} extends BaseFragmentMVVM<Fragment${Name}Binding, ${Name}ViewModel> implements I${Name}ViewModel {

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
    public void initViewModel(ViewModelProvider.Factory factory) {
        mViewModel = ViewModelProviders.of(this, factory).get(${Name}ViewModel.class);
    }

    @Override
    public int getLayoutId() {
        return R.layout.${layoutName};
    }

    @Override
    protected void onVisible() {
        <#if hasArgument>
        if (getArguments() != null) {
            
        }
        </#if>
        mViewDataBinding.setViewModel(mViewModel);
    }
}
