package ${packageName}.${funtionName}

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle

import ${packageName}.${funtionName}.viewmodel.I${Name}ViewModel
import ${packageName}.${funtionName}.viewmodel.${Name}ViewModel

import ${packageName}.view.NavigatorApp

import ${packageName}.R
import ${packageName}.databinding.Activity${Name}Binding

import tran.nam.core.view.mvvm.BaseActivityMVVM

class ${activityName} : BaseActivityMVVM<Activity${Name}Binding, ${Name}ViewModel>(), I${Name}ViewModel{

    override fun layoutId(): Int {
        mViewModel = ViewModelProviders.of(this, mViewModelFactory).get(${Name}ViewModel::class.java)
        return R.layout.${layoutName}
    }

    override fun initView(savedInstanceState: Bundle?) {
        mViewDataBinding.viewModel = mViewModel
    }

    override fun initData(savedInstanceState: Bundle?) {

    }

    <#if hasStatusBar>
    override fun setStatusBar() {

    }
    </#if>
}
