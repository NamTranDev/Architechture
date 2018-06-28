package nam.tran.architechture.mapper;

import javax.inject.Inject;
import javax.inject.Singleton;

@SuppressWarnings("unused")
@Singleton
public class DataMapper {

    public final PreferenceMapper preferenceMapper;

    @Inject
    DataMapper(PreferenceMapper preferenceMapper) {
        this.preferenceMapper = preferenceMapper;
    }
}
