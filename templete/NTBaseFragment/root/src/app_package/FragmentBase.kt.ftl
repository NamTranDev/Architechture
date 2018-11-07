package ${packageName}.${funtionName}

<#if hasArgument>
import android.os.Bundle
</#if>

import ${packageName}.R

<#if hasBiding>
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import android.databinding.DataBindingUtil
import ${packageName}.databinding.Fragment${Name}Binding
</#if>

<#if hasInject>
import tran.nam.core.view.BaseFragmentInjection
<#else>
import tran.nam.core.view.BaseFragment
</#if>

class ${fragmentName} : <#if hasInject>BaseFragmentInjection<#else>BaseFragment</#if>(){

    <#if hasBiding>
    private lateinit var mViewDataBinding : Fragment${Name}Binding
    </#if>

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

    public override fun layoutId(): Int {
         return R.layout.${layoutName}
    }

    <#if hasBiding>
    override fun initLayout(inflater: LayoutInflater, container: ViewGroup?): View {
        mViewDataBinding = DataBindingUtil.inflate(inflater, layoutId(), container, false)
        return mViewDataBinding.root
    }
    </#if>

    override fun onVisible() {
        <#if hasArgument>
        arguments?.let {

        }
        </#if>
    }
}
