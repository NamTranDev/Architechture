package tran.nam.core.view;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import javax.inject.Inject;
import javax.inject.Named;

import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;
import tran.nam.core.Navigator;
import tran.nam.core.di.module.BaseActivityModule;

/**
 * Abstract Activity for all Activities to extend.
 * <p>
 * <b>DEPENDENCY INJECTION</b>
 * We could extend {@link dagger.android.DaggerActivity} so we can get the boilerplate
 * dagger code for free. However, we want to avoid inheritance (if possible and it is in this case)
 * so that we have to option to inherit from something else later on if needed.
 */
public abstract class BaseActivityInjection<T extends Navigator> extends BaseActivity implements HasSupportFragmentInjector {

    @Inject
    protected T mNavigator;

    /**
     * A reference to the FragmentManager is injected and used instead of the getter method. This
     * enables ease of mocking and verification in tests (in case Activity needs testing).
     *
     * For more details, see https://github.com/vestrel00/android-dagger-butterknife-mvp/pull/52
     */
    @Inject
    @Named(BaseActivityModule.ACTIVITY_FRAGMENT_MANAGER)
    protected FragmentManager fragmentManager;

    @Inject
    DispatchingAndroidInjector<Fragment> fragmentInjector;

    @Override
    protected void inject() {
        AndroidInjection.inject(this);
    }

    @Override
    public final AndroidInjector<Fragment> supportFragmentInjector() {
        return fragmentInjector;
    }
}
