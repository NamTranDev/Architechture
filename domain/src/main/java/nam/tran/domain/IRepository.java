package nam.tran.domain;

import android.arch.lifecycle.LiveData;

import java.util.List;

import nam.tran.domain.entity.SoccerSeasonEntity;
import nam.tran.domain.entity.TeamEntity;
import nam.tran.domain.entity.state.Resource;

public interface IRepository {

    LiveData<Resource<List<SoccerSeasonEntity>>> getListSeason();

    LiveData<Resource<List<TeamEntity>>> getListTeam(int idSeason);
}
