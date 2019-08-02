package nam.tran.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import nam.tran.data.entities.UserEntityData

@Database(entities = [UserEntityData::class], version = 1, exportSchema = false)
@TypeConverters(ConvertData::class)
abstract class DbProvider : RoomDatabase() {
    abstract fun userAccess(): UserDAO
}
