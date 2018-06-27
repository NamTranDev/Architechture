package nam.tran.architechture.view.main.activity.season;


import android.support.v4.app.Fragment;

import javax.inject.Named;

import dagger.Binds;
import dagger.Module;
import tran.nam.core.di.inject.PerFragment;
import tran.nam.core.di.module.BaseFragmentModule;

/**
 * Provides soccer season fragment dependencies.
 */
@Module(includes = {
        BaseFragmentModule.class
})
public abstract class SoccerSeasonFragmentModule {

    /**
     * As per the contract specified in {@link BaseFragmentModule}; "This must be included in all
     * fragment modules, which must provide a concrete implementation of {@link android.app.Fragment}
     * and named {@link BaseFragmentModule#FRAGMENT}.
     *
     * @param fragment the soccer season fragment
     * @return the fragment
     */

    @Binds
    @Named(BaseFragmentModule.FRAGMENT)
    @PerFragment
    abstract Fragment fragment(SoccerSeasonFragment fragment);
}
