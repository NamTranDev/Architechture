package nam.tran.architechture.mapper;

import javax.inject.Inject;
import javax.inject.Singleton;

import nam.tran.architechture.application.model.PreferenceModel;
import nam.tran.domain.entity.PreferenceEntity;

@SuppressWarnings({"FieldCanBeLocal", "unused"})
@Singleton
public class PreferenceMapper {

    private PreferenceModel preferenceModel;

    @Inject
    PreferenceMapper(PreferenceModel preferenceModel) {
        this.preferenceModel = preferenceModel;
    }

    /**
     * Transform a {@link PreferenceEntity} into an {@link PreferenceModel}.
     *
     * @param data Object to be transformed.
     * @return {@link PreferenceModel}.
     */
    public void transform(PreferenceEntity data) {
        if (data == null) {
            throw new IllegalArgumentException("Cannot transform a null value");
        }
    }

}
