package ${packageName}.${funtionName}

import androidx.fragment.app.Fragment

import dagger.Binds
import dagger.Module
<#if isChild>import tran.nam.core.di.inject.PerChildFragment<#else>import tran.nam.core.di.inject.PerFragment</#if>

/**
 * Provides ${classToResource(fragmentName)?replace('_', ' ')} fragment dependencies.
 */
@Module
abstract class ${Name}FragmentModule {

    @Binds
    <#if isChild>@PerChildFragment<#else>@PerFragment</#if>
    internal abstract fun fragmentInject(fragment: ${fragmentName}): Fragment
}
