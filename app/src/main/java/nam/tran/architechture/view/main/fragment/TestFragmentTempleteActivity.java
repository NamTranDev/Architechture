package nam.tran.architechture.view.main.fragment;

import android.os.Bundle;

import nam.tran.architechture.R;
import nam.tran.architechture.view.NavigatorApp;
import nam.tran.architechture.view.main.fragment.parent.ParentFragment;
import tran.nam.core.view.BaseActivityWithFragment;
import tran.nam.core.view.BaseFragment;

import android.databinding.DataBindingUtil;

import nam.tran.architechture.databinding.ActivityTestFragmentTempleteBinding;

public class TestFragmentTempleteActivity extends BaseActivityWithFragment<NavigatorApp>{

    private ActivityTestFragmentTempleteBinding mViewDataBinding;

    @Override
    public int getLayoutId() {
        return R.layout.activity_test_fragment_templete;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        mViewDataBinding = DataBindingUtil.setContentView(this, getLayoutId());
        mViewDataBinding.setView(this);
    }

    @Override
    public void initData(Bundle savedInstanceState) {

    }

    @Override
    public BaseFragment[] getFragments() {
        return new BaseFragment[]{ParentFragment.getInstance()};
    }

    @Override
    public int getContentLayoutId() {
        return R.id.test_fragment_templete_contain;
    }

}
