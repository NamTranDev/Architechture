package nam.tran.domain.mapper;

import javax.inject.Inject;
import javax.inject.Singleton;

@SuppressWarnings("unused")
@Singleton
public class DataEntityMapper {

    public final PreferenceEntityMapper mPreferenceEntityMapper;
    public final SoccerSeasonEntityDataMapper mSoccerSeasonEntityDataMapper;
    public final TeamEntityDataMapper mTeamEntityDataMapper;

    @Inject
    DataEntityMapper(PreferenceEntityMapper mPreferenceEntityMapper, SoccerSeasonEntityDataMapper mSoccerSeasonEntityDataMapper, TeamEntityDataMapper mTeamEntityDataMapper) {
        this.mPreferenceEntityMapper = mPreferenceEntityMapper;
        this.mSoccerSeasonEntityDataMapper = mSoccerSeasonEntityDataMapper;
        this.mTeamEntityDataMapper = mTeamEntityDataMapper;
    }
}
