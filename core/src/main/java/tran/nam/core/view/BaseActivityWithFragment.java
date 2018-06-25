package tran.nam.core.view;


import android.support.v4.app.FragmentManager;

import javax.inject.Inject;

@SuppressWarnings("unused")
public abstract class BaseActivityWithFragment extends BaseActivityInjection implements IFragmentProvider {

    @Inject
    public FragmentHelper<BaseFragment> mFragmentHelper;

    protected void addFragment(BaseFragment fragment) {
        mFragmentHelper.pushFragment(fragment);
    }

    protected void showFragment(int position) {
        mFragmentHelper.showFragment(position);
    }

    protected void replaceFragment(BaseFragment fragment) {
        mFragmentHelper.replaceFragment(fragment);
    }

    @Override
    protected void initFragment() {
        mFragmentHelper.setupFragment();
    }

    @Override
    public FragmentManager fragmentManager() {
        return fragmentManager;
    }

    protected void popToRoot() {
        mFragmentHelper.popFragmentToRoot();
    }

    @Override
    public void onBackPressed() {
        if (!mFragmentHelper.popFragment()) {
            mNavigator.finish(this);
        }
    }
}
