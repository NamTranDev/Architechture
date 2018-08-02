package nam.tran.architechture.view.main.fragment.parent;

import android.support.v4.app.Fragment;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import nam.tran.architechture.view.main.fragment.parent.season.SoccerSeasonChildFragment;
import nam.tran.architechture.view.main.fragment.parent.season.SoccerSeasonChildFragmentModule;
import nam.tran.architechture.view.main.fragment.parent.team.TeamChildFragment;
import nam.tran.architechture.view.main.fragment.parent.team.TeamChildFragmentModule;
import tran.nam.core.di.inject.PerChildFragment;
import tran.nam.core.di.inject.PerFragment;

/**
 * Provides parent fragment dependencies.
 */
@Module
public abstract class ParentFragmentModule {

    /**
     * Provides the injector for the {@link SoccerSeasonChildFragmentModule}, which has access to the
     * dependencies provided by this fragment and activity and application instance
     * (singleton scoped objects).
     */
    @PerChildFragment
    @ContributesAndroidInjector(modules = SoccerSeasonChildFragmentModule.class)
    abstract SoccerSeasonChildFragment injectorSoccerSeasonChildFragment();

    /**
     * Provides the injector for the {@link TeamChildFragmentModule}, which has access to the
     * dependencies provided by this fragment and activity and application instance
     * (singleton scoped objects).
     */
    @PerChildFragment
    @ContributesAndroidInjector(modules = TeamChildFragmentModule.class)
    abstract TeamChildFragment injectorTeamChildFragment();

    @Binds
    @PerFragment
    abstract Fragment fragment(ParentFragment fragment);
}
