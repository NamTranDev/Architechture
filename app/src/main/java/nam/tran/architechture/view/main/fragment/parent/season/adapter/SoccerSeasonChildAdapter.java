package nam.tran.architechture.view.main.fragment.parent.season.adapter;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import nam.tran.architechture.R;
import nam.tran.architechture.databinding.AdapterSoccerSeasonBinding;
import nam.tran.architechture.model.SoccerSeasonModel;
import tran.nam.common.DataBoundListAdapter;

public class SoccerSeasonChildAdapter extends DataBoundListAdapter<SoccerSeasonModel,AdapterSoccerSeasonBinding> {

    private final DataBindingComponent dataBindingComponent;
    private final OnItemSoccerSeasonClick onItemSoccerSeasonClick;

    public SoccerSeasonChildAdapter(DataBindingComponent dataBindingComponent, OnItemSoccerSeasonClick onItemSoccerSeasonClick) {
        this.dataBindingComponent = dataBindingComponent;
        this.onItemSoccerSeasonClick = onItemSoccerSeasonClick;
    }

    @Override
    protected AdapterSoccerSeasonBinding createBinding(ViewGroup parent) {
        AdapterSoccerSeasonBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.adapter_soccer_season, parent, false, dataBindingComponent);
        binding.getRoot().setOnClickListener(v -> onItemSoccerSeasonClick.onItemSoccerSeasonClick(binding.getSoccerSeason()));
        return binding;
    }

    @Override
    protected void bind(AdapterSoccerSeasonBinding binding, SoccerSeasonModel item) {
        binding.setSoccerSeason(item);
    }

    @Override
    protected boolean areItemsTheSame(SoccerSeasonModel oldItem, SoccerSeasonModel newItem) {
        return oldItem.id == newItem.id;
    }

    @Override
    protected boolean areContentsTheSame(SoccerSeasonModel oldItem, SoccerSeasonModel newItem) {
        return oldItem.caption.equals(newItem.caption) && oldItem.league.equals(newItem.league);
    }

    public interface OnItemSoccerSeasonClick{
        void onItemSoccerSeasonClick(SoccerSeasonModel item);
    }
}
