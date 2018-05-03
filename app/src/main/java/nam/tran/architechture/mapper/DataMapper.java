package nam.tran.architechture.mapper;

import javax.inject.Inject;
import javax.inject.Singleton;

@SuppressWarnings("unused")
@Singleton
public class DataMapper {

    public final PreferenceMapper preferenceMapper;
    public final SoccerSeasonModelDataMapper soccerSeasonModelDataMapper;

    @Inject
    DataMapper(PreferenceMapper preferenceMapper, SoccerSeasonModelDataMapper soccerSeasonModelDataMapper) {
        this.preferenceMapper = preferenceMapper;
        this.soccerSeasonModelDataMapper = soccerSeasonModelDataMapper;
    }
}
