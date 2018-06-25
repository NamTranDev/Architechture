package nam.tran.architechture.view.main.activity.team.adapter;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import nam.tran.architechture.R;
import nam.tran.architechture.databinding.AdapterTeamBinding;
import nam.tran.architechture.model.TeamModel;
import tran.nam.common.DataBoundListAdapter;

public class TeamAdapter extends DataBoundListAdapter<TeamModel, AdapterTeamBinding> {

    private final DataBindingComponent dataBindingComponent;

    public TeamAdapter(DataBindingComponent dataBindingComponent) {
        this.dataBindingComponent = dataBindingComponent;
    }

    @Override
    protected AdapterTeamBinding createBinding(ViewGroup parent) {
        return DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.adapter_team, parent, false, dataBindingComponent);
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
}
