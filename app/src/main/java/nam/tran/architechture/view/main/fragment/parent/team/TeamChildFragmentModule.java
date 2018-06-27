package nam.tran.architechture.view.main.fragment.parent.team;

import android.support.v4.app.Fragment;

import javax.inject.Named;

import dagger.Binds;
import dagger.Module;
import tran.nam.core.di.inject.PerChildFragment;
import tran.nam.core.di.module.BaseChildFragmentModule;
import tran.nam.core.di.module.BaseFragmentModule;

/**
 * Provides soccer season fragment dependencies.
 */
@Module(includes = {
        BaseChildFragmentModule.class
})
public abstract class TeamChildFragmentModule {

    /**
     * As per the contract specified in {@link BaseFragmentModule}; "This must be included in all
     * fragment modules, which must provide a concrete implementation of {@link android.app.Fragment}
     * and named {@link BaseFragmentModule#FRAGMENT}.
     *
     * @param fragment the team child fragment
     * @return the fragment
     */

    @Binds
    @Named(BaseChildFragmentModule.CHILD_FRAGMENT)
    @PerChildFragment
    abstract Fragment fragment(TeamChildFragment fragment);
}
