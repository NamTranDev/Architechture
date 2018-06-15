package nam.tran.architechture.test.activity.mvvmWithFragment.module;

import android.support.v7.app.AppCompatActivity;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import nam.tran.architechture.test.activity.mvvmWithFragment.TestActivityMvvmWithFM;
import nam.tran.architechture.test.activity.mvvmWithFragment.fragmentTest.TestFragmentWithActivityMvvmWithFm;
import nam.tran.architechture.test.activity.mvvmWithFragment.fragmentTest.module.TestFragmentWithActivityMvvmWithFmFragmentModule;
import nam.tran.architechture.view.season.SoccerSeasonFragment;
import nam.tran.architechture.view.season.module.SoccerSeasonFragmentModule;
import tran.nam.core.di.inject.PerActivity;
import tran.nam.core.di.inject.PerFragment;
import tran.nam.core.di.module.BaseActivityModule;
import tran.nam.core.view.BaseActivity;

import tran.nam.core.view.BaseFragment;
import tran.nam.core.view.IFragmentProvider;

/**
 * Provides test activity mvvm with fm activity dependencies.
 */
@Module(includes = {
        BaseActivityModule.class
})
public abstract class TestActivityMvvmWithFmActivityModule {

    /**
     * Provides the injector for the {@link SoccerSeasonFragmentModule}, which has access to the dependencies
     * provided by this activity and application instance (singleton scoped objects).
     */
    @PerFragment
    @ContributesAndroidInjector(modules = TestFragmentWithActivityMvvmWithFmFragmentModule.class)
    abstract TestFragmentWithActivityMvvmWithFm testFragmentWithActivityMvvmWithFmInjector();

    /**
     * As per the contract specified in {@link BaseActivityModule}; "This must be included in all
     * activity modules, which must provide a concrete implementation of {@link AppCompatActivity}."
     * <p>
     * This provides the activity required to inject the
     * {@link BaseActivityModule#ACTIVITY_FRAGMENT_MANAGER} into the
     * {@link BaseActivity}.
     *
     * @param activity the test activity mvvm with fm activity
     * @return the activity
     */
    @Binds
    @PerActivity
    abstract AppCompatActivity activity(TestActivityMvvmWithFM activity);


    @Binds
    @PerActivity
    abstract IFragmentProvider<BaseFragment> providerFragmentHelper(TestActivityMvvmWithFM activity);

}
