package nam.tran.architechture.view.main.fragment.parent.season;


import android.support.v4.app.Fragment;

import dagger.Binds;
import dagger.Module;
import tran.nam.core.di.inject.PerChildFragment;

/**
 * Provides soccer season fragment dependencies.
 */
@Module
public abstract class SoccerSeasonChildFragmentModule {


    @Binds
    @PerChildFragment
    abstract Fragment fragment(SoccerSeasonChildFragment fragment);
}
