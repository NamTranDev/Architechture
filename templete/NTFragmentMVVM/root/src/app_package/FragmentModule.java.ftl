package ${packageName}.${funtionName};

import android.support.v4.app.Fragment;

import javax.inject.Named;

import dagger.Binds;
import dagger.Module;
<#if isChild>
import tran.nam.core.di.inject.PerChildFragment;
import tran.nam.core.di.module.BaseChildFragmentModule;
<#else>
import tran.nam.core.di.inject.PerFragment;
</#if>

import tran.nam.core.di.module.BaseFragmentModule;

/**
 * Provides ${classToResource(fragmentName)?replace('_', ' ')} fragment dependencies.
 */
@Module(includes = {
    <#if isChild>
    BaseChildFragmentModule.class
    <#else>
    BaseFragmentModule.class
    </#if>
})
public abstract class ${Name}FragmentModule {

    /**
     * As per the contract specified in {@link BaseFragmentModule}; "This must be included in all
     * fragment modules, which must provide a concrete implementation of {@link android.app.Fragment}
     * and named {@link BaseFragmentModule#FRAGMENT}.
     *
     * @param fragment the ${classToResource(fragmentName)?replace('_', ' ')} fragment
     * @return the fragment
     */

    @Binds
    <#if isChild>
    @Named(BaseChildFragmentModule.CHILD_FRAGMENT)
    @PerChildFragment
    <#else>
    @Named(BaseFragmentModule.FRAGMENT)
    @PerFragment
    </#if>
    abstract Fragment fragment(${fragmentName} fragment);
}
