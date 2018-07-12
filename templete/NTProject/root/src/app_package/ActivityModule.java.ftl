package ${packageName}.view.${funtionName};

import android.support.v7.app.AppCompatActivity;

import dagger.Binds;
import dagger.Module;
import ${packageName}.view.${funtionName}.${activityName};
import tran.nam.core.di.inject.PerActivity;
import tran.nam.core.di.module.BaseActivityModule;
import tran.nam.core.view.BaseActivity;

import tran.nam.core.view.BaseFragment;
import tran.nam.core.view.IFragmentProvider;
/**
 * Provides ${classToResource(activityName)?replace('_', ' ')} activity dependencies.
 */
@Module(includes = {
        BaseActivityModule.class
})
public abstract class ${Name}ActivityModule {

    /**
     * As per the contract specified in {@link BaseActivityModule}; "This must be included in all
     * activity modules, which must provide a concrete implementation of {@link AppCompatActivity}."
     * <p>
     * This provides the activity required to inject the
     * {@link BaseActivityModule#ACTIVITY_FRAGMENT_MANAGER} into the
     * {@link BaseActivity}.
     *
     * @param activity the ${classToResource(activityName)?replace('_', ' ')} activity
     * @return the activity
     */
    @Binds
    @PerActivity
    abstract AppCompatActivity activity(${activityName} activity);


    @Binds
    @PerActivity
	abstract IFragmentProvider<BaseFragment> providerFragmentHelper(${activityName} activity);
}
