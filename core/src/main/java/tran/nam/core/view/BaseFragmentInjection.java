package tran.nam.core.view;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.support.v4.app.Fragment;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.AndroidSupportInjection;
import dagger.android.support.HasSupportFragmentInjector;
import tran.nam.core.Navigator;

@SuppressWarnings({"unused", "deprecation"})
public abstract class BaseFragmentInjection<T extends Navigator> extends BaseFragment implements HasSupportFragmentInjector {

    @Inject
    protected T mNavigator;

    @Inject
    DispatchingAndroidInjector<Fragment> childFragmentInjector;

    @Override
    public void onAttach(Activity activity) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            // Perform injection here before M, L (API 22) and below because onAttach(Context)
            // is not yet available at L.
            AndroidSupportInjection.inject(this);
        }
        super.onAttach(activity);
    }

    @Override
    public void onAttach(Context context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            // Perform injection here for M (API 23) due to deprecation of onAttach(Activity).
            AndroidSupportInjection.inject(this);
        }
        super.onAttach(context);
    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return childFragmentInjector;
    }

    protected void addFragmentFromActivity(BaseFragment fragment) {
        if (activity() != null && activity() instanceof BaseActivityWithFragment && !activity().isFinishing())
            ((BaseActivityWithFragment) activity()).addFragment(fragment);
    }

    protected void showFragmentFromActivity(int position) {
        if (activity() != null && activity() instanceof BaseActivityWithFragment && !activity().isFinishing())
            ((BaseActivityWithFragment) activity()).showFragment(position);
    }

    protected void replaceFragmentFromActivity(BaseFragment fragment) {
        if (activity() != null && activity() instanceof BaseActivityWithFragment && !activity().isFinishing())
            ((BaseActivityWithFragment) activity()).replaceFragment(fragment);
    }

    protected void popFragmentToRoot() {
        if (activity() != null && activity() instanceof BaseActivityWithFragment && !activity().isFinishing())
            ((BaseActivityWithFragment) activity()).popToRoot();
    }

    protected void addFragmentFromFragment(BaseFragment fragment) {
        if (getParentFragment() != null && getParentFragment() instanceof BaseParentFragment) {
            ((BaseParentFragment) getParentFragment()).addChildFragment(fragment);
        }
    }

    protected void showFragmentFromFragment(int position) {
        if (getParentFragment() != null && getParentFragment() instanceof BaseParentFragment) {
            ((BaseParentFragment) getParentFragment()).showChildFragment(position);
        }
    }

    protected void replaceFragmentFromFragment(BaseFragment fragment) {
        if (getParentFragment() != null && getParentFragment() instanceof BaseParentFragment) {
            ((BaseParentFragment) getParentFragment()).replaceChildFragment(fragment);
        }
    }

    protected void popChildFragmentToRoot() {
        if (getParentFragment() != null && getParentFragment() instanceof BaseParentFragment) {
            ((BaseParentFragment) getParentFragment()).popChildFragmentToRoot();
        }
    }
}
