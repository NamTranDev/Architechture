package nam.tran.architechture.mapper;

import javax.inject.Inject;
import javax.inject.Singleton;

@SuppressWarnings("unused")
@Singleton
public class DataMapper {

    public final PreferenceMapper preferenceMapper;
    public final SoccerSeasonModelDataMapper soccerSeasonModelDataMapper;
    public final TeamModelDataMapper teamModelDataMapper;

    @Inject
    DataMapper(PreferenceMapper preferenceMapper, SoccerSeasonModelDataMapper soccerSeasonModelDataMapper, TeamModelDataMapper teamModelDataMapper) {
        this.preferenceMapper = preferenceMapper;
        this.soccerSeasonModelDataMapper = soccerSeasonModelDataMapper;
        this.teamModelDataMapper = teamModelDataMapper;
    }
}
