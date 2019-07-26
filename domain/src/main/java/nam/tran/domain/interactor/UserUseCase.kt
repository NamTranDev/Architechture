package nam.tran.domain.interactor

import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single
import nam.tran.domain.entities.UserEntity
import nam.tran.domain.repositories.IAndroidInteractor
import nam.tran.domain.repositories.IUserRepository
import javax.inject.Inject

class UserUseCase @Inject constructor(private val iAndroidInteractor: IAndroidInteractor, private val iUserRepository: IUserRepository) {

    fun login(userName: String, password: String): Completable {
        return Single.fromCallable {
            iAndroidInteractor.getBasicAuth(userName, password)
        }.flatMapCompletable {
            iUserRepository.login(it)
        }
    }

    fun getUser(): Flowable<UserEntity> {
        return iUserRepository.getUserInfo()
    }
}