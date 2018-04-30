package nam.tran.domain.mapper;

import javax.inject.Inject;
import javax.inject.Singleton;

@SuppressWarnings("unused")
@Singleton
public class DataEntityMapper {

    private final PreferenceEntityMapper mPreferenceEntityMapper;

    @Inject
    DataEntityMapper(PreferenceEntityMapper mPreferenceEntityMapper) {
        this.mPreferenceEntityMapper = mPreferenceEntityMapper;
    }

    public PreferenceEntityMapper getPreferenceEntityMapper() {
        return mPreferenceEntityMapper;
    }
}
