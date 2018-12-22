package ${packageName}.${funtionName}

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle

import ${packageName}.${funtionName}.viewmodel.I${Name}ViewModel
import ${packageName}.${funtionName}.viewmodel.${Name}ViewModel

import ${applicationPackage}.R
import ${applicationPackage}.databinding.Activity${Name}Binding

import tran.nam.core.view.mvvm.BaseActivityMVVM

class ${activityName} : BaseActivityMVVM<Activity${Name}Binding, ${Name}ViewModel>(), I${Name}ViewModel{

    override fun layoutId(): Int {
        mViewModel = ViewModelProviders.of(this, mViewModelFactory).get(${Name}ViewModel::class.java)
        return R.layout.${layoutName}
    }

    <#if hasStatusBar>
    override fun setStatusBar() {

    }
    </#if>

    override fun init(savedInstanceState: Bundle?) {
        mViewDataBinding.viewModel = mViewModel
    }
}
