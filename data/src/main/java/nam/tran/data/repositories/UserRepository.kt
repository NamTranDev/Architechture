package nam.tran.data.repositories

import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.Single
import nam.tran.data.Logger
import nam.tran.data.database.DbProvider
import nam.tran.data.local.IPreference
import nam.tran.data.mapper.UserEntityMapper
import nam.tran.data.network.IApi
import nam.tran.domain.entities.UserEntity
import nam.tran.domain.repositories.IUserRepository
import javax.inject.Inject

class UserRepository @Inject internal constructor(private val iApi: IApi,private val iDbProvider: DbProvider,private val iPreference: IPreference) : IUserRepository {

    override fun login(token: String): Completable {
        return iApi.login(token).toFlowable().flatMapCompletable {
            iApi.getUserInfo(it.login).flatMapCompletable {
                iPreference.user = it.login
                iDbProvider.userAccess().insert(it)
                Completable.complete()
            }
        }
    }

    override fun getUserInfo(): Flowable<UserEntity> {
        return iApi.getUserInfo(iPreference.user).doOnNext {
            iDbProvider.userAccess().update(it)
        }.onErrorResumeNext { _: Throwable ->
            Logger.debug("onErrorResumeNext")
            Flowable.empty()
        }.flatMap {
            iDbProvider.userAccess().getUser(iPreference.user).map {
                Logger.debug(it)
                val mapper = UserEntityMapper()
                mapper.mapFrom(it)
            }
        }
    }

}