package nam.tran.data.database

import androidx.room.Dao
import androidx.room.Query
import io.reactivex.Flowable
import nam.tran.data.entities.UserEntityData

@Dao
abstract class UserDAO : BaseDao<UserEntityData>(){

    @Query("SELECT * FROM User WHERE login = :username")
    abstract fun getUser(username: String) : Flowable<UserEntityData>
}