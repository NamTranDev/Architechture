package nam.tran.architechture.mapper

import javax.inject.Inject
import javax.inject.Singleton

import nam.tran.architechture.model.PreferenceModel
import nam.tran.domain.entity.PreferenceEntity

@Singleton
class PreferenceMapper @Inject
internal constructor(private val preferenceModel: PreferenceModel) {

    /**
     * Transform a [PreferenceEntity] into an [PreferenceModel].
     *
     * @param data Object to be transformed.
     * @return [PreferenceModel].
     */
    fun transform(data: PreferenceEntity?) {
        if (data == null) {
            throw IllegalArgumentException("Cannot transform a null value")
        }
    }

}
