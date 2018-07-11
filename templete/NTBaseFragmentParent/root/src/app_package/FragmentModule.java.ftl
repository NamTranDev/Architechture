package ${packageName}.${funtionName};

import android.support.v4.app.Fragment;

import javax.inject.Named;

import dagger.Binds;
import dagger.Module;
import tran.nam.core.di.inject.PerFragment;

import tran.nam.core.di.module.BaseFragmentModule;

/**
 * Provides ${classToResource(fragmentName)?replace('_', ' ')} fragment dependencies.
 */
@Module(includes = {
    BaseFragmentModule.class
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
    @Named(BaseFragmentModule.FRAGMENT)
    @PerFragment
    abstract Fragment fragment(${fragmentName} fragment);
}
