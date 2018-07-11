package ${packageName}.${funtionName};

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;

import ${packageName}.${funtionName}.viewmodel.I${Name}ViewModel;
import ${packageName}.${funtionName}.viewmodel.${Name}ViewModel;

import ${applicationPackage}.R;
import ${applicationPackage}.databinding.Activity${Name}Binding;

import tran.nam.core.view.mvvm.BaseActivityMVVM;

public class ${activityName} extends BaseActivityMVVM<Activity${Name}Binding, ${Name}ViewModel> implements I${Name}ViewModel {

    @Override
    public int getLayoutId() {
        mViewModel = ViewModelProviders.of(this, mViewModelFactory).get(${Name}ViewModel.class);
        return R.layout.${layoutName};
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        mViewDataBinding.setViewModel(mViewModel);
    }

    <#if hasStatusBar>
    @Override
    protected void setStatusBar() {

    }
    </#if>
}
