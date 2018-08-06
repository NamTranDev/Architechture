package nam.tran.flatform.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase

import nam.tran.flatform.model.response.session.SoccerSeason
import nam.tran.flatform.model.response.team.Team

@Database(entities = [SoccerSeason::class, Team::class], version = 1, exportSchema = false)
abstract class DbProvider : RoomDatabase() {
    abstract fun soccerSeasonDao(): SoccerSeasonDao

    abstract fun teamDao(): TeamDao
}
