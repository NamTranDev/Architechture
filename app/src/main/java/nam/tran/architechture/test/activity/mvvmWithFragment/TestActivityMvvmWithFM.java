package nam.tran.architechture.test.activity.mvvmWithFragment;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;

import java.util.List;
import java.util.Objects;

import nam.tran.architechture.model.TeamModel;
import nam.tran.architechture.test.activity.mvvmWithFragment.fragmentTest.TestFragmentWithActivityMvvmWithFm;
import nam.tran.architechture.test.activity.mvvmWithFragment.viewmodel.ITestActivityMvvmWithFmViewModel;
import nam.tran.architechture.test.activity.mvvmWithFragment.viewmodel.TestActivityMvvmWithFmViewModel;

import nam.tran.architechture.R;
import nam.tran.architechture.databinding.ActivityTestActivityMvvmWithFmBinding;

import tran.nam.core.view.mvvm.BaseActivityWithFragmentMVVM;
import tran.nam.core.view.BaseFragment;
import tran.nam.util.Constant;

public class TestActivityMvvmWithFM extends BaseActivityWithFragmentMVVM<ActivityTestActivityMvvmWithFmBinding, TestActivityMvvmWithFmViewModel> implements ITestActivityMvvmWithFmViewModel {

    private TestFragmentWithActivityMvvmWithFm fragment;

    @Override
    public int getLayoutId() {
        mViewModel = ViewModelProviders.of(this, mViewModelFactory).get(TestActivityMvvmWithFmViewModel.class);
        return R.layout.activity_test_activity_mvvm_with_fm;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        mViewDataBinding.setViewModel(mViewModel);
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        super.initData(savedInstanceState);
        int idSeasoon = Objects.requireNonNull(getIntent().getExtras()).getInt(Constant.KEY_INTENT.ID_SEASON);
        mViewModel.getTeamFollowSeason(idSeasoon);
    }

    @Override
    public BaseFragment[] getFragments() {
        fragment = TestFragmentWithActivityMvvmWithFm.getIntance();
        return new BaseFragment[]{fragment};
    }

    @Override
    public int getContentLayoutId() {
        return R.id.test_activity_mvvm_with_fm_contain;
    }

    @Override
    public void updateData(List<TeamModel> data) {
        fragment.displayTeams(data);
    }

    @Override
    public void updateView() {
        mViewDataBinding.setViewModel(mViewModel);
        mViewDataBinding.executePendingBindings();
    }
}
