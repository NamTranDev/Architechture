package nam.tran.architechture.view.main.fragment;

import android.support.v7.app.AppCompatActivity;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import nam.tran.architechture.view.main.fragment.TestFragmentTempleteActivity;
import nam.tran.architechture.view.main.fragment.parent.ParentFragment;
import nam.tran.architechture.view.main.fragment.parent.ParentFragmentModule;
import tran.nam.core.di.inject.PerActivity;
import tran.nam.core.di.inject.PerFragment;
import tran.nam.core.di.module.BaseActivityModule;
import tran.nam.core.view.BaseActivity;

import tran.nam.core.view.BaseFragment;
import tran.nam.core.view.IFragmentProvider;

/**
 * Provides test fragment templete activity dependencies.
 */
@Module(includes = {
        BaseActivityModule.class
})
public abstract class TestFragmentTempleteActivityModule {

    /**
    * Provides the injector for the {@link ParentFragmentModule}, which has access to the dependencies
    * provided by this application instance (singleton scoped objects).
    */
    @PerFragment
    @ContributesAndroidInjector(modules = ParentFragmentModule.class)
    abstract ParentFragment injectorParentFragment();

    /**
     * As per the contract specified in {@link BaseActivityModule}; "This must be included in all
     * activity modules, which must provide a concrete implementation of {@link AppCompatActivity}."
     * <p>
     * This provides the activity required to inject the
     * {@link BaseActivityModule#ACTIVITY_FRAGMENT_MANAGER} into the
     * {@link BaseActivity}.
     *
     * @param activity the test fragment templete activity
     * @return the activity
     */
    @Binds
    @PerActivity
    abstract AppCompatActivity activity(TestFragmentTempleteActivity activity);


    @Binds
    @PerActivity
    abstract IFragmentProvider<BaseFragment> providerFragmentHelper(TestFragmentTempleteActivity activity);
}
