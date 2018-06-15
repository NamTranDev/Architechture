package nam.tran.architechture.test.activity.withFragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;

import nam.tran.architechture.R;
import nam.tran.architechture.databinding.ActivityTestActivityWithFragmentBinding;
import nam.tran.architechture.test.activity.withFragment.fragmentTest.TestFragmentWithActivityWithFragment;
import tran.nam.core.view.BaseActivityWithFragment;
import tran.nam.core.view.BaseFragment;

public class TestActivityWithFragment extends BaseActivityWithFragment {

    private ActivityTestActivityWithFragmentBinding mViewDataBinding;

    @Override
    public int getLayoutId() {
        return R.layout.activity_test_activity_with_fragment;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        mViewDataBinding = DataBindingUtil.setContentView(this, getLayoutId());
    }

    @Override
    public void initData(Bundle savedInstanceState) {

    }

    @Override
    public BaseFragment[] getFragments() {
        return new BaseFragment[]{TestFragmentWithActivityWithFragment.getInstance()};
    }

    @Override
    public int getContentLayoutId() {
        return R.id.test_activity_with_fragment_contain;
    }

}
