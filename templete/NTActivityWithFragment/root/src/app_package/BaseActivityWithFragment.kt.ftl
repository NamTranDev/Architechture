package ${packageName}.${funtionName}

import android.os.Bundle

import ${packageName}.R
import tran.nam.core.view.BaseActivityWithFragment
import tran.nam.core.view.BaseFragment

<#if hasBiding>
import android.databinding.DataBindingUtil
import ${packageName}.databinding.Activity${Name}Binding
</#if>

class ${activityName} : BaseActivityWithFragment() {

    <#if hasBiding>
    private lateinit var mViewDataBinding : Activity${Name}Binding
    </#if>
    
    override val fragments: Array<BaseFragment>
            get() = arrayOf()
    
    override val contentLayoutId: Int
        get() = R.id.${layoutName?replace('activity_', '')}_contain

    override fun layoutId(): Int {
        return R.layout.${layoutName}
    }

    override fun initView(savedInstanceState: Bundle?) {
        <#if hasBiding>
        mViewDataBinding = DataBindingUtil.setContentView(this, layoutId())
        mViewDataBinding.view = this
        </#if>
    }
    
    override fun initData(savedInstanceState: Bundle?) {
    
    }
    
    <#if hasStatusBar>
    override fun setStatusBar() {
    
    }
    </#if>
}
