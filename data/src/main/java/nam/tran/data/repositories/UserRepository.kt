package nam.tran.data.repositories

import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single
import nam.tran.data.database.DbProvider
import nam.tran.data.local.IPreference
import nam.tran.data.mapper.UserEntityMapper
import nam.tran.data.network.IApi
import nam.tran.domain.entities.UserEntity
import nam.tran.domain.repositories.IUserRepository
import javax.inject.Inject

class UserRepository @Inject internal constructor(private val iApi: IApi,private val iDbProvider: DbProvider,private val iPreference: IPreference) : IUserRepository {

    override fun login(token: String): Completable {
        return iApi.login(token).doOnSuccess {
            iDbProvider.userAccess().insert(it)
            iPreference.user = it.login
        }.ignoreElement()
    }

    override fun getUserInfo(): Flowable<UserEntity> {
        return iDbProvider.userAccess().getUser(iPreference.user).map {
            val mapper = UserEntityMapper()
            mapper.mapFrom(it)
        }
    }

}