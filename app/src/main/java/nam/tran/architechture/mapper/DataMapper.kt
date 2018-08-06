package nam.tran.architechture.mapper

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DataMapper @Inject
internal constructor(val preferenceMapper: PreferenceMapper, val soccerSeasonModelDataMapper: SoccerSeasonModelDataMapper, val teamModelDataMapper: TeamModelDataMapper)
