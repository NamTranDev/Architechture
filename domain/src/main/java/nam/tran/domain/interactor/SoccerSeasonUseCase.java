package nam.tran.domain.interactor;

import android.arch.lifecycle.LiveData;

import java.util.List;

import javax.inject.Inject;

import nam.tran.domain.IRepository;
import nam.tran.domain.entity.SoccerSeasonEntity;
import nam.tran.domain.entity.state.Resource;
import nam.tran.domain.interactor.core.UseCase;
import nam.tran.domain.interactor.usecase.ISoccerSeasonUseCase;

public class SoccerSeasonUseCase extends UseCase implements ISoccerSeasonUseCase {

    @Inject
    SoccerSeasonUseCase(IRepository iRepository) {
        super(iRepository);
    }

    @Override
    public LiveData<Resource<List<SoccerSeasonEntity>>> getSoccerSeasonData() {
        return iRepository.getListSeason();
    }
}
