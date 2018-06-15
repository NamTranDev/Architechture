package nam.tran.domain.interactor.usecase;

import android.arch.lifecycle.LiveData;

import java.util.List;

import nam.tran.domain.entity.SoccerSeasonEntity;
import nam.tran.domain.entity.TeamEntity;
import nam.tran.domain.entity.state.Resource;

public interface ITeamUseCase {

    LiveData<Resource<List<TeamEntity>>> getTeamData(int idSeason,int type);
}