package nam.tran.architechture.test.activity.mvvmWithFragment.fragmentTest.module;


import android.support.v4.app.Fragment;

import javax.inject.Named;

import dagger.Binds;
import dagger.Module;
import nam.tran.architechture.test.activity.mvvmWithFragment.fragmentTest.TestFragmentWithActivityMvvmWithFm;
import tran.nam.core.di.inject.PerFragment;
import tran.nam.core.di.module.BaseFragmentModule;

/**
 * Provides fragment dependencies.
 */
@Module(includes = {
        BaseFragmentModule.class
})
public abstract class TestFragmentWithActivityMvvmWithFmFragmentModule {

    @Binds
    @Named(BaseFragmentModule.FRAGMENT)
    @PerFragment
    abstract Fragment fragment(TestFragmentWithActivityMvvmWithFm fragment);
}
