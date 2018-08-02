package ${packageName}.view.splash;

import android.support.v7.app.AppCompatActivity;

import dagger.Binds;
import dagger.Module;
import ${packageName}.view.splash.SplashActivity;
import tran.nam.core.di.inject.PerActivity;
import tran.nam.core.di.module.BaseActivityModule;
import tran.nam.core.view.BaseActivity;

/**
 * Provides main activity dependencies.
 */
@Module(includes = {
        BaseActivityModule.class
})
public abstract class SplashActivityModule {

    /**
     * As per the contract specified in {@link BaseActivityModule}; "This must be included in all
     * activity modules, which must provide a concrete implementation of {@link AppCompatActivity}."
     * <p>
     * This provides the activity required to inject the
     * {@link BaseActivityModule#ACTIVITY_FRAGMENT_MANAGER} into the
     * {@link BaseActivity}.
     *
     * @param activity : the splash activity
     * @return the activity
     */
    @Binds
    @PerActivity
    abstract AppCompatActivity activity(SplashActivity activity);
}
