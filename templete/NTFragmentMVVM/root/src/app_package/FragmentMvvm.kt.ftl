package ${packageName}.${funtionName}

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders

import ${packageName}.${funtionName}.viewmodel.I${Name}ViewModel
import ${packageName}.${funtionName}.viewmodel.${Name}ViewModel

import ${applicationPackage}.R
import ${applicationPackage}.databinding.Fragment${Name}Binding

import tran.nam.core.view.mvvm.BaseFragmentMVVM

class ${fragmentName} : BaseFragmentMVVM<Fragment${Name}Binding, ${Name}ViewModel>() , I${Name}ViewModel {

    override fun initViewModel(factory : ViewModelProvider.Factory?) {
        mViewModel = ViewModelProviders.of(this, factory).get(${Name}ViewModel::class.java)
    }

    override fun layoutId(): Int {
        return R.layout.${layoutName}
    }

    override fun onVisible() {
        mViewDataBinding?.viewModel = mViewModel
    }
}
