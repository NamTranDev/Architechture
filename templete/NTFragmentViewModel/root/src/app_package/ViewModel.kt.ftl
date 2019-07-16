package ${packageName}.${funtionName}.viewmodel

import android.app.Application

import javax.inject.Inject

import tran.nam.core.viewmodel.BaseViewModel
<#if isLoading>
import nam.tran.data.model.core.state.Resource
import androidx.lifecycle.LiveData
</#if>

class ${Name}ViewModel @Inject internal constructor(application: Application)
: BaseFragmentViewModel(application){

     <#if isLoading>
     var results: LiveData<Resource<*>>? = null

     fun resource(): Resource<*>? {
        return results?.value
     }
     </#if>
}
