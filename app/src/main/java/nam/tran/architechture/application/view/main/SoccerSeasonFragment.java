package nam.tran.architechture.application.view.main;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingComponent;
import android.os.Bundle;

import java.util.List;

import nam.tran.architechture.R;
import nam.tran.architechture.application.model.SoccerSeasonModel;
import nam.tran.architechture.application.view.adapter.SoccerSeasonAdapter;
import nam.tran.architechture.application.viewmodel.ISoccerSeasonViewModel;
import nam.tran.architechture.application.viewmodel.SoccerSeasonViewModel;
import nam.tran.architechture.biding.FragmentDataBindingComponent;
import nam.tran.architechture.databinding.FragmentSoccerSeasonBinding;
import tran.nam.common.AutoClearedValue;
import tran.nam.core.view.BaseFragment;
import tran.nam.core.view.mvvm.BaseFragmentMVVM;

public class SoccerSeasonFragment extends BaseFragmentMVVM<FragmentSoccerSeasonBinding,SoccerSeasonViewModel> implements ISoccerSeasonViewModel {

    private DataBindingComponent dataBindingComponent = new FragmentDataBindingComponent(this);
    private AutoClearedValue<SoccerSeasonAdapter> adapter;

    public static SoccerSeasonFragment getInstance() {
        return new SoccerSeasonFragment();
    }

    @Override
    public void initViewModel(ViewModelProvider.Factory factory) {
        mViewModel = ViewModelProviders.of(this,factory).get(SoccerSeasonViewModel.class);
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_soccer_season;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        SoccerSeasonAdapter adapter = new SoccerSeasonAdapter(dataBindingComponent,this);
        this.adapter = new AutoClearedValue<>(this,adapter);
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

    }
}
