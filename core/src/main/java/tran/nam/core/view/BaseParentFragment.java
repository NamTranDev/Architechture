package tran.nam.core.view;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;
import tran.nam.util.Constant;

public abstract class BaseParentFragment extends BaseFragmentInjection implements HasSupportFragmentInjector, IFragmentProvider<BaseFragment>,IParentFragmentListener {

    public FragmentHelper<BaseFragment> mChildFragmentHelper;

    @Inject
    DispatchingAndroidInjector<Fragment> fragmentInjector;

    protected void addChildFragment(BaseFragment fragment) {
        mChildFragmentHelper.pushFragment(fragment);
    }

    protected void showChildFragment(int position) {
        mChildFragmentHelper.showFragment(position);
    }

    protected void replaceChildFragment(BaseFragment fragment) {
        mChildFragmentHelper.replaceFragment(fragment);
    }

    @Override
    protected void initChildFragment() {
        mChildFragmentHelper = new FragmentHelper<>(this);
        mChildFragmentHelper.setupFragment();
    }

    @Override
    public FragmentManager fragmentManager() {
        return childFragmentManager;
    }

    @Override
    public final AndroidInjector<Fragment> supportFragmentInjector() {
        return fragmentInjector;
    }

    protected void popChildFragmentToRoot() {
        mChildFragmentHelper.popFragmentToRoot();
    }

    @Override
    public boolean popChildFragment(int level) {
        return mChildFragmentHelper.popFragment(level);
    }
}
