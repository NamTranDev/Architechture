package nam.tran.architechture.test.activity.withFragment.module;

import android.support.v7.app.AppCompatActivity;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import nam.tran.architechture.test.activity.withFragment.TestActivityWithFragment;
import nam.tran.architechture.test.activity.withFragment.fragmentTest.TestFragmentWithActivityWithFragment;
import nam.tran.architechture.test.activity.withFragment.fragmentTest.module.TestFragmentWithActivityWithFragmentModule;
import nam.tran.architechture.view.season.SoccerSeasonFragment;
import nam.tran.architechture.view.season.module.SoccerSeasonFragmentModule;
import tran.nam.core.di.inject.PerActivity;
import tran.nam.core.di.inject.PerFragment;
import tran.nam.core.di.module.BaseActivityModule;
import tran.nam.core.view.BaseActivity;

import tran.nam.core.view.BaseFragment;
import tran.nam.core.view.IFragmentProvider;

/**
 * Provides test activity with activity dependencies.
 */
@Module(includes = {
        BaseActivityModule.class
})
public abstract class TestActivityWithFragmentModule {

    /**
     * Provides the injector for the {@link TestFragmentWithActivityWithFragmentModule}, which has access to the dependencies
     * provided by this activity and application instance (singleton scoped objects).
     */
    @PerFragment
    @ContributesAndroidInjector(modules = TestFragmentWithActivityWithFragmentModule.class)
    abstract TestFragmentWithActivityWithFragment testFragmentWithActivityWithFragmentInjector();

    /**
     * As per the contract specified in {@link BaseActivityModule}; "This must be included in all
     * activity modules, which must provide a concrete implementation of {@link AppCompatActivity}."
     * <p>
     * This provides the activity required to inject the
     * {@link BaseActivityModule#ACTIVITY_FRAGMENT_MANAGER} into the
     * {@link BaseActivity}.
     *
     * @param activity the test activity with activity
     * @return the activity
     */
    @Binds
    @PerActivity
    abstract AppCompatActivity activity(TestActivityWithFragment activity);

    @Binds
    @PerActivity
    abstract IFragmentProvider<BaseFragment> providerFragmentHelper(TestActivityWithFragment activity);

}
