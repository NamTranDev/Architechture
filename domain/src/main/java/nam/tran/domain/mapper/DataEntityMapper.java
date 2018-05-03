package nam.tran.domain.mapper;

import javax.inject.Inject;
import javax.inject.Singleton;

@SuppressWarnings("unused")
@Singleton
public class DataEntityMapper {

    public final PreferenceEntityMapper mPreferenceEntityMapper;
    public final SoccerSeasonEntityDataMapper mSoccerSeasonEntityDataMapper;

    @Inject
    DataEntityMapper(PreferenceEntityMapper mPreferenceEntityMapper, SoccerSeasonEntityDataMapper mSoccerSeasonEntityDataMapper) {
        this.mPreferenceEntityMapper = mPreferenceEntityMapper;
        this.mSoccerSeasonEntityDataMapper = mSoccerSeasonEntityDataMapper;
    }
}
