package nam.tran.architechture.view.main.fragment.parent.team.detail;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import nam.tran.architechture.R;
import nam.tran.architechture.databinding.FragmentTeamChildBinding;
import nam.tran.architechture.databinding.FragmentTeamDetailBinding;
import nam.tran.architechture.model.TeamModel;
import tran.nam.common.AutoClearedValue;
import tran.nam.core.view.BaseFragment;
import tran.nam.core.view.BaseFragmentInjection;
import tran.nam.util.Constant;

public class TeamDetailFragment extends BaseFragment {

    private FragmentTeamDetailBinding mViewDataBinding;
    private AutoClearedValue<FragmentTeamDetailBinding> binding;

    public static TeamDetailFragment getInstance(TeamModel team){
        TeamDetailFragment fragment = new TeamDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable(Constant.KEY_ARGUMENT.TEAM_DATA,team);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_team_detail;
    }

    @Override
    public View initLayout(@NonNull LayoutInflater inflater, @Nullable ViewGroup container) {
        mViewDataBinding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false);
        binding = new AutoClearedValue<>(this,mViewDataBinding);
        return mViewDataBinding.getRoot();
    }

    @Override
    protected void onVisible() {
        super.onVisible();

        if (getArguments() != null){
            TeamModel team = getArguments().getParcelable(Constant.KEY_ARGUMENT.TEAM_DATA);
            binding.get().setTeam(team);
        }

    }
}
