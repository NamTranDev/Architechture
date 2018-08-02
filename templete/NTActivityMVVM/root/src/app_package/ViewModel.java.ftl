package ${packageName}.${funtionName}.viewmodel;

import android.app.Application;
import android.support.annotation.NonNull;

import javax.inject.Inject;

import tran.nam.core.viewmodel.BaseActivityViewModel;
import tran.nam.core.viewmodel.IProgressViewModel;
<#if hasProgress>
import nam.tran.domain.entity.state.Resource;
import android.arch.lifecycle.MutableLiveData;
</#if>

public class ${Name}ViewModel extends BaseActivityViewModel<I${Name}ViewModel> <#if hasProgress>implements IProgressViewModel</#if>{

	<#if hasProgress>
	private MutableLiveData<Resource> results = new MutableLiveData<>();
	</#if>

    @Inject
    ${Name}ViewModel(@NonNull Application application) {
        super(application);
    }

	<#if hasProgress>
    @Override
    public Resource getResource() {
        return results.getValue();
    }
    </#if>
}
