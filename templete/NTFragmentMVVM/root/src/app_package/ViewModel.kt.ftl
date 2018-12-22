package ${packageName}.${funtionName}.viewmodel

import android.app.Application

import javax.inject.Inject

import tran.nam.core.viewmodel.BaseFragmentViewModel
import tran.nam.core.viewmodel.IProgressViewModel
<#if hasProgress>
import nam.tran.domain.entity.state.Resource
import androidx.lifecycle.MutableLiveData
</#if>

class ${Name}ViewModel @Inject internal constructor(application: Application)
: BaseFragmentViewModel(application)<#if hasProgress>, IProgressViewModel </#if>{

     <#if hasProgress>
     private val results = MutableLiveData<Resource<*>>()

     override fun resource(): Resource<*>?{
             return results.value
         }
     </#if>


}
