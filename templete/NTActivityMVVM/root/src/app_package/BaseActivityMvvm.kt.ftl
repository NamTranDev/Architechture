package ${packageName}.${funtionName}

import android.os.Bundle

<#if isViewModelLoading>
import androidx.lifecycle.ViewModelProviders
import ${packageName}.${funtionName}.viewmodel.${Name}ViewModel
<#if applicationPackage??>
import ${applicationPackage}.databinding.Activity${Name}Binding
</#if>
import tran.nam.core.view.mvvm.BaseActivityLoadingVM
<#elseif isViewModel>
import androidx.lifecycle.ViewModelProviders
import ${packageName}.${funtionName}.viewmodel.${Name}ViewModel
<#if applicationPackage??>
import ${applicationPackage}.databinding.Activity${Name}Binding
</#if>
import tran.nam.core.view.mvvm.BaseActivityVM
<#elseif hasInject>
import tran.nam.core.view.BaseActivityInjection
<#if hasBiding>
import androidx.databinding.DataBindingUtil
<#if applicationPackage??>
import ${applicationPackage}.databinding.Activity${Name}Binding
</#if>
</#if>
<#else>
import tran.nam.core.view.BaseActivity
<#if hasBiding>
import androidx.databinding.DataBindingUtil
<#if applicationPackage??>
import ${applicationPackage}.databinding.Activity${Name}Binding
</#if>
</#if>
</#if>
<#if applicationPackage??>
import ${applicationPackage}.R
</#if>

class ${activityName} : <#if isViewModelLoading>BaseActivityLoadingVM<Activity${Name}Binding, ${Name}ViewModel>()<#elseif isViewModel>BaseActivityVM<Activity${Name}Binding, ${Name}ViewModel>()<#elseif hasInject>BaseActivityInjection()<#else>BaseActivity()</#if>{

    <#if isViewModelLoading || isViewModel>
    override fun layoutId(): Int {
        mViewModel = ViewModelProviders.of(this, mViewModelFactory).get(${Name}ViewModel::class.java)
        return R.layout.${layoutName}
    }
    <#else>
    override fun layoutId(): Int {
        return R.layout.${layoutName}
    }
    </#if>
    <#if hasBiding && !isViewModelLoading && !isViewModel>
    private var mViewDataBinding: Activity${underscoreToCamelCase(classToResource(activityName))}Binding? = null
    </#if>
    <#if hasStatusBar>
    override fun setStatusBar() {

    }
    </#if>

    override fun init(savedInstanceState: Bundle?) {
        <#if hasBiding && !isViewModelLoading && !isViewModel>
        mViewDataBinding = DataBindingUtil.setContentView(this, layoutId())
        mViewDataBinding.view = this
        </#if>
        <#if isViewModelLoading && isViewModel>
        mViewDataBinding.viewModel = mViewModel
        </#if>
    }
}
