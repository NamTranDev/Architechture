package nam.tran.architechture.view.main.fragment.parent.team.adapter;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import nam.tran.architechture.R;
import nam.tran.architechture.databinding.AdapterTeamBinding;
import nam.tran.architechture.model.TeamModel;
import tran.nam.common.DataBoundListAdapter;

public class TeamChildAdapter extends DataBoundListAdapter<TeamModel, AdapterTeamBinding> {

    private final DataBindingComponent dataBindingComponent;
    private OnItemTeamChildListener onItemTeamChildListener;

    public TeamChildAdapter(DataBindingComponent dataBindingComponent,OnItemTeamChildListener onItemTeamChildListener) {
        this.dataBindingComponent = dataBindingComponent;
        this.onItemTeamChildListener = onItemTeamChildListener;
    }

    @Override
    protected AdapterTeamBinding createBinding(ViewGroup parent) {
        AdapterTeamBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.adapter_team, parent, false, dataBindingComponent);
        binding.getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemTeamChildListener.onItemTeamChildListener(binding.getTeam());
            }
        });
        return binding;
    }

    @Override
    protected void bind(AdapterTeamBinding binding, TeamModel item) {
        binding.setTeam(item);
    }

    @Override
    protected boolean areItemsTheSame(TeamModel oldItem, TeamModel newItem) {
        return oldItem.idSeason == newItem.idSeason;
    }

    @Override
    protected boolean areContentsTheSame(TeamModel oldItem, TeamModel newItem) {
        return oldItem.name.equals(newItem.name);
    }

    public interface OnItemTeamChildListener{
        void onItemTeamChildListener(TeamModel team);
    }
}
