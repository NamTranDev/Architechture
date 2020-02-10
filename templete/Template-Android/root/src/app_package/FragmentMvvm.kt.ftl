package ${packageName}

import android.os.Bundle
import android.view.View

<#if isViewModel>
import ${packageName}.${Name}ViewModel
import ${applicationPackage}.databinding.Fragment${Name}Binding
</#if>

<#if !isViewModel && hasBiding>
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import ${applicationPackage}.databinding.Fragment${Name}Binding
</#if>
import ${applicationPackage}.R

class ${fragmentName} : <#if isViewModel>BaseFragmentVM<Fragment${Name}Binding, ${Name}ViewModel>()<#else>BaseFragment()</#if>{

    <#if hasBiding && !isViewModel>
    private lateinit var mViewDataBinding : Fragment${Name}Binding
    </#if>

    override val layoutId: Int
        get() = R.layout.${layoutName}

    <#if hasBiding && !isViewModel>
    override fun initLayout(inflater: LayoutInflater, container: ViewGroup?): View {
        mViewDataBinding = DataBindingUtil.inflate(inflater, layoutId, container, false)
        return mViewDataBinding.root
    }
    </#if>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    	super.onViewCreated(view, savedInstanceState)
    	<#if isViewModel>mViewDataBinding?.viewModel = mViewModel<#elseif hasBiding>mViewDataBinding.view = this</#if>
    }
}
