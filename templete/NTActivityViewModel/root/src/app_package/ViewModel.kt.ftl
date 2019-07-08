package ${packageName}.${funtionName}.viewmodel

import android.app.Application

import javax.inject.Inject

import tran.nam.core.viewmodel.BaseActivityViewModel
<#if isViewModelLoading>
import nam.tran.data.model.core.state.Resource
import androidx.lifecycle.LiveData
</#if>

class ${Name}ViewModel @Inject internal constructor(application: Application)
: BaseActivityViewModel(application){

     <#if isViewModelLoading>
     var results: LiveData<Resource<*>>? = null

     fun resource(): Resource<*>? {
        return results?.value
     }
     </#if>
}
