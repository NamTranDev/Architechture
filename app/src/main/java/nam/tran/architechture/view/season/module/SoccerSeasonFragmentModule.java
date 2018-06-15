package nam.tran.architechture.view.season.module;


import android.support.v4.app.Fragment;

import javax.inject.Named;

import dagger.Binds;
import dagger.Module;
import nam.tran.architechture.view.season.SoccerSeasonFragment;
import tran.nam.core.di.inject.PerFragment;
import tran.nam.core.di.module.BaseFragmentModule;

/**
 * Provides soccer season fragment dependencies.
 */
@Module(includes = {
        BaseFragmentModule.class
})
public abstract class SoccerSeasonFragmentModule {

    @Binds
    @Named(BaseFragmentModule.FRAGMENT)
    @PerFragment
    abstract Fragment fragment(SoccerSeasonFragment fragment);
}
