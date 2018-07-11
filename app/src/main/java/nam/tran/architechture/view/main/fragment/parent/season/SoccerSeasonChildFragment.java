package nam.tran.architechture.view.main.fragment.parent.season;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingComponent;
import android.os.Bundle;

import java.util.List;

import javax.inject.Inject;

import nam.tran.architechture.R;
import nam.tran.architechture.model.SoccerSeasonModel;
import nam.tran.architechture.model.TeamModel;
import nam.tran.architechture.view.NavigatorApp;
import nam.tran.architechture.view.main.fragment.parent.season.adapter.SoccerSeasonChildAdapter;
import nam.tran.architechture.view.main.fragment.parent.season.viewmodel.ISoccerSeasonChildViewModel;
import nam.tran.architechture.view.main.fragment.parent.season.viewmodel.SoccerSeasonChildViewModel;
import nam.tran.architechture.view.main.fragment.parent.team.TeamChildFragment;
import tran.nam.common.AutoClearedValue;
import nam.tran.architechture.databinding.FragmentSoccerSeasonChildBinding;
import tran.nam.core.biding.FragmentDataBindingComponent;
import tran.nam.core.view.mvvm.BaseFragmentMVVM;

public class SoccerSeasonChildFragment extends BaseFragmentMVVM<FragmentSoccerSeasonChildBinding, SoccerSeasonChildViewModel> implements ISoccerSeasonChildViewModel {

    private DataBindingComponent dataBindingComponent = new FragmentDataBindingComponent(this);
    private AutoClearedValue<SoccerSeasonChildAdapter> adapter;

    public static SoccerSeasonChildFragment getInstance() {
        return new SoccerSeasonChildFragment();
    }

    @Override
    public void initViewModel(ViewModelProvider.Factory factory) {
        mViewModel = ViewModelProviders.of(this, factory).get(SoccerSeasonChildViewModel.class);
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_soccer_season_child;
    }

    @Override
    protected boolean isHaveAnimation() {
        return false;
    }

    @Override
    protected void onVisible() {
        mViewDataBinding.setViewModel(mViewModel);
        SoccerSeasonChildAdapter adapter = new SoccerSeasonChildAdapter(dataBindingComponent, this);
        this.adapter = new AutoClearedValue<>(this, adapter);
        binding.get().rvSoccerSeason.setAdapter(adapter);
    }

    @Override
    public void updateData(List<SoccerSeasonModel> data) {
        adapter.get().replace(data);
    }

    @Override
    public void getTeamsData(List<TeamModel> data) {
        addFragmentFromFragment(TeamChildFragment.getInstance(data));
    }

    @Override
    public void updateView() {
        mViewDataBinding.setViewModel(mViewModel);
        mViewDataBinding.executePendingBindings();
    }

    @Override
    public void onItemSoccerSeasonClick(SoccerSeasonModel item) {
        mViewModel.getTeamFollowSeason(item.id);
    }
}
