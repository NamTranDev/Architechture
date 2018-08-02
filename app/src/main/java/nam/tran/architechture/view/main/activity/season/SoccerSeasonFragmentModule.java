package nam.tran.architechture.view.main.activity.season;


import android.support.v4.app.Fragment;

import javax.inject.Named;

import dagger.Binds;
import dagger.Module;
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
