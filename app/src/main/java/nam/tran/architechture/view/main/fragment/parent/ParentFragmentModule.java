package nam.tran.architechture.view.main.fragment.parent;

import android.support.v4.app.Fragment;

import javax.inject.Named;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import nam.tran.architechture.view.main.fragment.parent.season.SoccerSeasonChildFragment;
import nam.tran.architechture.view.main.fragment.parent.season.SoccerSeasonChildFragmentModule;
import nam.tran.architechture.view.main.fragment.parent.team.TeamChildFragment;
import nam.tran.architechture.view.main.fragment.parent.team.TeamChildFragmentModule;
import tran.nam.core.di.inject.PerChildFragment;
import tran.nam.core.di.inject.PerFragment;
import tran.nam.core.di.module.BaseFragmentModule;

/**
 * Provides parent fragment dependencies.
 */
@Module(includes = {
        BaseFragmentModule.class
})
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

    /**
     * As per the contract specified in {@link BaseFragmentModule}; "This must be included in all
     * fragment modules, which must provide a concrete implementation of {@link android.app.Fragment}
     * and named {@link BaseFragmentModule#FRAGMENT}.
     *
     * @param fragment the parent fragment
     * @return the fragment
     */

    @Binds
    @Named(BaseFragmentModule.FRAGMENT)
    @PerFragment
    abstract Fragment fragment(ParentFragment fragment);
}
