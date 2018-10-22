package ${packageName}.${funtionName};

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
<#if hasArgument>
import android.os.Bundle
</#if>

import ${packageName}.${funtionName}.viewmodel.I${Name}ViewModel
import ${packageName}.${funtionName}.viewmodel.${Name}ViewModel

import ${applicationPackage}.R
import ${applicationPackage}.databinding.Fragment${Name}Binding

import tran.nam.core.view.mvvm.BaseFragmentMVVM

class ${fragmentName} : BaseFragmentMVVM<Fragment${Name}Binding, ${Name}ViewModel>() , I${Name}ViewModel {

    companion object {
                <#if hasArgument>
                fun newInstance() = ${fragmentName}().apply {
                               arguments = Bundle().apply {

                               }
                           }
                <#else>
                @JvmStatic
                fun newInstance(): ${fragmentName} = ${fragmentName}()
                </#if>
            }

    override fun initViewModel(factory : ViewModelProvider.Factory?) {
        mViewModel = ViewModelProviders.of(this, factory).get(${Name}ViewModel::class.java)
    }

    override fun layoutId(): Int {
        return R.layout.${layoutName}
    }

    override fun onVisible() {
        mViewDataBinding.viewModel = mViewModel
            <#if hasArgument>
            arguments?.let {

            }
            </#if>
        }
}
