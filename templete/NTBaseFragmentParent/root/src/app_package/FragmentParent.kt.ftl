package ${packageName}.${funtionName};

<#if hasArgument>
import android.os.Bundle
</#if>

import ${applicationPackage}.R

<#if hasBiding>
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.databinding.DataBindingUtil
import ${applicationPackage}.databinding.Fragment${Name}Binding
</#if>
import tran.nam.core.view.BaseFragment
import tran.nam.core.view.BaseParentFragment

class ${fragmentName} : BaseParentFragment(){

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

    override val fragments: Array<BaseFragment>
        get() = arrayOf()

    override val contentLayoutId: Int
        get() = R.id.${layoutName?replace('fragment_', '')}_contain

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

    override fun isHaveAnimation(): Boolean {
        return false
    }

    override val fragments: Array<BaseFragment>
            get() = arrayOf()
    
    override val
}
