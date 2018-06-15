package nam.tran.architechture.test.activity.mvvmWithFragment.fragmentTest;

import android.databinding.DataBindingComponent;
import android.os.Bundle;

import android.databinding.DataBindingUtil;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import nam.tran.architechture.databinding.FragmentTestFragmentWithActivityMvvmWithFmBinding;
import nam.tran.architechture.model.TeamModel;
import nam.tran.architechture.view.team.adapter.TeamAdapter;
import tran.nam.common.AutoClearedValue;
import tran.nam.core.biding.FragmentDataBindingComponent;
import tran.nam.core.view.BaseFragment;

import nam.tran.architechture.R;

public class TestFragmentWithActivityMvvmWithFm extends BaseFragment {

    private android.databinding.DataBindingComponent dataBindingComponent = new FragmentDataBindingComponent(this);
    private AutoClearedValue<TeamAdapter> adapter;
    private FragmentTestFragmentWithActivityMvvmWithFmBinding mBiding;

    public static TestFragmentWithActivityMvvmWithFm getIntance() {
        return new TestFragmentWithActivityMvvmWithFm();
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_test_fragment_with_activity_mvvm_with_fm;
    }

    @Override
    public View initLayout(@NonNull LayoutInflater inflater, @Nullable ViewGroup container) {
        mBiding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false);
        return mBiding.getRoot();
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        adapter = new AutoClearedValue<>(this,new TeamAdapter(dataBindingComponent));
        mBiding.rvTeam.setAdapter(adapter.get());
    }

    public void displayTeams(List<TeamModel> data) {
        adapter.get().replace(data);
    }
}