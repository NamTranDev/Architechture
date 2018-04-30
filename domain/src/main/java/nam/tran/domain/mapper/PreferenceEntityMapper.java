package nam.tran.domain.mapper;

import javax.inject.Inject;
import javax.inject.Singleton;

import nam.tran.domain.entity.PreferenceEntity;
import nam.tran.flatform.local.IPreference;

@SuppressWarnings({"UnnecessaryLocalVariable", "unused"})
@Singleton
public class PreferenceEntityMapper {

    @Inject PreferenceEntityMapper() {
    }

    /**
     * Transform a {@link IPreference} into an {@link PreferenceEntity}.
     *
     * @param data Object to be transformed.
     * @return {@link PreferenceEntity}.
     */
    public PreferenceEntity transform(IPreference data) {
        if (data == null) {
            throw new IllegalArgumentException("Cannot transform a null value");
        }
        final PreferenceEntity preferenceEntity = new PreferenceEntity();

        return preferenceEntity;
    }
}
