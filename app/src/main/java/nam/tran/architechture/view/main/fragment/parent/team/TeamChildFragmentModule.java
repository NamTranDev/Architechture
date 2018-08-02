package nam.tran.architechture.view.main.fragment.parent.team;

import android.support.v4.app.Fragment;

import dagger.Binds;
import dagger.Module;
import tran.nam.core.di.inject.PerChildFragment;

/**
 * Provides soccer season fragment dependencies.
 */
@Module
public abstract class TeamChildFragmentModule {


    @Binds
    @PerChildFragment
    abstract Fragment fragment(TeamChildFragment fragment);
}
