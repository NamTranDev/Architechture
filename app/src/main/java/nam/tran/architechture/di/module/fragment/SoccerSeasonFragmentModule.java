package nam.tran.architechture.di.module.fragment;


import android.support.v4.app.Fragment;

import dagger.Binds;
import dagger.Module;
import nam.tran.architechture.application.view.main.SoccerSeasonFragment;
import tran.nam.core.di.inject.PerFragment;

/**
 * Provides soccer season fragment dependencies.
 */
@Module
public abstract class SoccerSeasonFragmentModule {

    @Binds
    @PerFragment
    abstract Fragment fragment(SoccerSeasonFragment fragment);
}
