package nam.tran.architechture.view.main.activity.team;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingComponent;
import android.os.Bundle;

import java.util.List;
import java.util.Objects;

import nam.tran.architechture.model.TeamModel;
import nam.tran.architechture.view.main.activity.team.adapter.TeamAdapter;
import nam.tran.architechture.view.main.activity.team.viewmodel.ITeamViewModel;
import nam.tran.architechture.view.main.activity.team.viewmodel.TeamViewModel;

import nam.tran.architechture.R;
import nam.tran.architechture.databinding.ActivityTeamBinding;

import tran.nam.core.biding.ActivityDataBindingComponent;
import tran.nam.core.view.mvvm.BaseActivityMVVM;
import tran.nam.util.Constant;

public class TeamActivity extends BaseActivityMVVM<ActivityTeamBinding, TeamViewModel> implements ITeamViewModel {

    private android.databinding.DataBindingComponent dataBindingComponent = new ActivityDataBindingComponent(this);
    private TeamAdapter adapter;

    @Override
    public int getLayoutId() {
        mViewModel = ViewModelProviders.of(this, mViewModelFactory).get(TeamViewModel.class);
        return R.layout.activity_team;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        mViewDataBinding.setViewModel(mViewModel);
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        adapter = new TeamAdapter(dataBindingComponent);
        mViewDataBinding.rvTeam.setAdapter(adapter);
        super.initData(savedInstanceState);
    }

    @Override
    public void updateView() {
        mViewDataBinding.setViewModel(mViewModel);
        mViewDataBinding.executePendingBindings();
    }

    @Override
    public void updateData(List<TeamModel> data) {
        adapter.replace(data);
    }

    @Override
    public int getIdSeasonSoccer() {
        return Objects.requireNonNull(getIntent().getExtras()).getInt(Constant.KEY_INTENT.ID_SEASON);
    }

    @Override
    public void onBackPressed() {
        mNavigator.finish(this);
    }
}
