package nam.tran.domain.repositories

import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single
import nam.tran.domain.entities.UserEntity

interface IUserRepository {
    fun login(token: String): Completable
    fun getUserInfo() : Flowable<UserEntity>
}