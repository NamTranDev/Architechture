package nam.tran.architechture.view.main.fragment.parent.team;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import nam.tran.architechture.R;
import nam.tran.architechture.databinding.FragmentTeamChildBinding;
import nam.tran.architechture.model.TeamModel;
import nam.tran.architechture.view.main.fragment.parent.team.adapter.TeamChildAdapter;
import nam.tran.architechture.view.main.fragment.parent.team.detail.TeamDetailFragment;
import tran.nam.common.AutoClearedValue;
import tran.nam.core.biding.FragmentDataBindingComponent;
import tran.nam.core.view.BaseFragmentInjection;
import tran.nam.util.Constant;

public class TeamChildFragment extends BaseFragmentInjection implements TeamChildAdapter.OnItemTeamChildListener {

    private FragmentTeamChildBinding mViewDataBinding;
    private AutoClearedValue<FragmentTeamChildBinding> binding;

    private android.databinding.DataBindingComponent dataBindingComponent = new FragmentDataBindingComponent(this);
    private AutoClearedValue<TeamChildAdapter> adapter;

    public static TeamChildFragment getInstance(List<TeamModel> teams) {
        TeamChildFragment fragment = new TeamChildFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList(Constant.KEY_ARGUMENT.LIST_TEAM_DATA, (ArrayList<? extends Parcelable>) teams);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_team_child;
    }

    @Override
    public View initLayout(@NonNull LayoutInflater inflater, @Nullable ViewGroup container) {
        mViewDataBinding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false);
        binding = new AutoClearedValue<>(this,mViewDataBinding);
        return mViewDataBinding.getRoot();
    }

    @Override
    protected void onVisible() {
        if (getArguments() != null) {
            List<TeamModel> teams = getArguments().getParcelableArrayList(Constant.KEY_ARGUMENT.LIST_TEAM_DATA);
            TeamChildAdapter adapter = new TeamChildAdapter(dataBindingComponent,this);
            adapter.replace(teams);
            this.adapter = new AutoClearedValue<>(this, adapter);
            binding.get().rvTeam.setAdapter(this.adapter.get());
        }
    }

    @Override
    public void onItemTeamChildListener(TeamModel team) {
        addFragmentFromFragment(TeamDetailFragment.getInstance(team));
    }
}
