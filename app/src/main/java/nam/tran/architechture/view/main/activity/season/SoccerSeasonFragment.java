package nam.tran.architechture.view.main.activity.season;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingComponent;

import java.util.List;

import javax.inject.Inject;

import nam.tran.architechture.R;
import nam.tran.architechture.databinding.FragmentSoccerSeasonBinding;
import nam.tran.architechture.model.SoccerSeasonModel;
import nam.tran.architechture.view.NavigatorApp;
import nam.tran.architechture.view.main.activity.season.adapter.SoccerSeasonAdapter;
import nam.tran.architechture.view.main.activity.season.viewmodel.ISoccerSeasonViewModel;
import nam.tran.architechture.view.main.activity.season.viewmodel.SoccerSeasonViewModel;
import tran.nam.common.AutoClearedValue;
import tran.nam.core.biding.FragmentDataBindingComponent;
import tran.nam.core.view.mvvm.BaseFragmentMVVM;

public class SoccerSeasonFragment extends BaseFragmentMVVM<FragmentSoccerSeasonBinding, SoccerSeasonViewModel> implements ISoccerSeasonViewModel {

    @Inject
    NavigatorApp mNavigatorApp;

    private DataBindingComponent dataBindingComponent = new FragmentDataBindingComponent(this);
    private AutoClearedValue<SoccerSeasonAdapter> adapter;

    public static SoccerSeasonFragment getInstance() {
        return new SoccerSeasonFragment();
    }

    @Override
    public void initViewModel(ViewModelProvider.Factory factory) {
        mViewModel = ViewModelProviders.of(this, factory).get(SoccerSeasonViewModel.class);
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_soccer_season;
    }

    @Override
    protected boolean isHaveAnimation() {
        return false;
    }

    @Override
    protected void onVisible() {
        mViewDataBinding.setViewModel(mViewModel);
        SoccerSeasonAdapter adapter = new SoccerSeasonAdapter(dataBindingComponent, this);
        this.adapter = new AutoClearedValue<>(this, adapter);
        binding.get().rvSoccerSeason.setAdapter(adapter);
    }

    @Override
    public void updateData(List<SoccerSeasonModel> data) {
        adapter.get().replace(data);
    }

    @Override
    public void updateView() {
        mViewDataBinding.setViewModel(mViewModel);
        mViewDataBinding.executePendingBindings();
    }

    @Override
    public void onItemSoccerSeasonClick(SoccerSeasonModel item) {
        mNavigatorApp.goToTeamActivity(activity(), item.id);
    }
}
