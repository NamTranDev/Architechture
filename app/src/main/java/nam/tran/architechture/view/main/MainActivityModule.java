package nam.tran.architechture.view.main;

import android.support.v7.app.AppCompatActivity;

import dagger.Binds;
import dagger.Module;
import nam.tran.architechture.view.main.MainActivity;
import tran.nam.core.di.inject.PerActivity;
import tran.nam.core.di.module.BaseActivityModule;
import tran.nam.core.view.BaseActivity;

/**
 * Provides main activity dependencies.
 */
@Module(includes = {
        BaseActivityModule.class
})
public abstract class MainActivityModule {

    /**
     * As per the contract specified in {@link BaseActivityModule}; "This must be included in all
     * activity modules, which must provide a concrete implementation of {@link AppCompatActivity}."
     * <p>
     * This provides the activity required to inject the
     * {@link BaseActivityModule#ACTIVITY_FRAGMENT_MANAGER} into the
     * {@link BaseActivity}.
     *
     * @param activity : the main activity
     * @return the activity
     */
    @Binds
    @PerActivity
    abstract AppCompatActivity activity(MainActivity activity);
}
