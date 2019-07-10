package ${packageName}.${funtionName}

import android.os.Bundle
import android.view.View

<#if isViewModel>
import tran.nam.core.view.mvvm.BaseFragmentVM
import ${packageName}.${funtionName}.viewmodel.${Name}ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import ${applicationPackage}.databinding.Fragment${Name}Binding
<#elseif hasInject>
import tran.nam.core.view.BaseFragmentInjection
<#else>
import tran.nam.core.view.BaseFragment
</#if>

<#if !isViewModel && hasBiding>
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import ${applicationPackage}.databinding.Fragment${Name}Binding
</#if>
import ${applicationPackage}.R

class ${fragmentName} : <#if isViewModel>BaseFragmentVM<Fragment${Name}Binding, ${Name}ViewModel>()<#elseif hasInject>BaseFragmentInjection()<#else>BaseFragment()</#if>{

	<#if isViewModel>
    override fun initViewModel(factory : ViewModelProvider.Factory?) {
        mViewModel = ViewModelProviders.of(this, factory).get(${Name}ViewModel::class.java)
    }
    </#if>

    <#if hasBiding && !isViewModel>
    private lateinit var mViewDataBinding : Fragment${Name}Binding
    </#if>

    override fun layoutId(): Int {
        return R.layout.${layoutName}
    }

    <#if hasBiding && !isViewModel>
    override fun initLayout(inflater: LayoutInflater, container: ViewGroup?): View {
        mViewDataBinding = DataBindingUtil.inflate(inflater, layoutId(), container, false)
        return mViewDataBinding.root
    }
    </#if>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    	<#if isViewModel>mViewDataBinding.viewModel = mViewModel<#elseif hasBiding>mViewDataBinding.view = this</#if>
    }
}
