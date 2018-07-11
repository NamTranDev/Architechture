package nam.tran.domain.interactor;

import android.arch.lifecycle.LiveData;

import java.util.List;

import javax.inject.Inject;

import nam.tran.domain.IRepository;
import nam.tran.domain.entity.SoccerSeasonEntity;
import nam.tran.domain.entity.TeamEntity;
import nam.tran.domain.entity.state.Resource;
import nam.tran.domain.interactor.core.UseCase;
import nam.tran.domain.interactor.usecase.ITeamUseCase;

public class TeamUseCase extends UseCase implements ITeamUseCase {

    @Inject
    TeamUseCase(IRepository iRepository) {
        super(iRepository);
    }

    @Override
    public LiveData<Resource<List<TeamEntity>>> getTeamData(int idSeason,int type) {
        return iRepository.getListTeam(idSeason,type);
    }
}
