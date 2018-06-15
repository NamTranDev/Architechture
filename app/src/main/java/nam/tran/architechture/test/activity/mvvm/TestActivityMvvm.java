package nam.tran.architechture.test.activity.mvvm;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingComponent;
import android.os.Bundle;

import java.util.List;

import javax.inject.Inject;

import nam.tran.architechture.R;
import nam.tran.architechture.databinding.ActivityTestActivityMvvmBinding;
import nam.tran.architechture.model.SoccerSeasonModel;
import nam.tran.architechture.model.TeamModel;
import nam.tran.architechture.test.activity.mvvm.viewmodel.ITestActivityMvvmViewModel;
import nam.tran.architechture.test.activity.mvvm.viewmodel.TestActivityMvvmViewModel;
import nam.tran.architechture.view.NavigatorApp;
import nam.tran.architechture.view.season.adapter.SoccerSeasonAdapter;
import tran.nam.core.biding.ActivityDataBindingComponent;
import tran.nam.core.view.mvvm.BaseActivityMVVM;
import tran.nam.util.Logger;

public class TestActivityMvvm extends BaseActivityMVVM<ActivityTestActivityMvvmBinding, TestActivityMvvmViewModel> implements ITestActivityMvvmViewModel, SoccerSeasonAdapter.OnItemSoccerSeasonClick {

    @Inject
    NavigatorApp mNavigator;

    private DataBindingComponent dataBindingComponent = new ActivityDataBindingComponent(this);
    private SoccerSeasonAdapter adapter;

    @Override
    public int getLayoutId() {
        mViewModel = ViewModelProviders.of(this, mViewModelFactory).get(TestActivityMvvmViewModel.class);
        return R.layout.activity_test_activity_mvvm;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        mViewDataBinding.setViewModel(mViewModel);
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        adapter = new SoccerSeasonAdapter(dataBindingComponent,this);
        mViewDataBinding.rvSoccerSeason.setAdapter(adapter);
        super.initData(savedInstanceState);
    }

    @Override
    public void updateData(List<SoccerSeasonModel> data) {
        adapter.replace(data);
    }

    @Override
    public void updateView() {
        mViewDataBinding.setViewModel(mViewModel);
        mViewDataBinding.executePendingBindings();
    }

    @Override
    public void getTeams(List<TeamModel> data) {
        Logger.debug("getTeams",data);
    }

    @Override
    public void onItemSoccerSeasonClick(SoccerSeasonModel item) {
//        mViewModel.getTeamFollowSeason(item.id);
        mNavigator.goToActivityMvvmWithFragment(this,item.id);
    }
}
