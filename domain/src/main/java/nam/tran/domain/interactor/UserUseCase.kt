package nam.tran.domain.interactor

import io.reactivex.Completable
import io.reactivex.CompletableSource
import io.reactivex.Flowable
import io.reactivex.Single
import nam.tran.domain.entities.EventEntity
import nam.tran.domain.entities.RepositoryEntity
import nam.tran.domain.entities.UserEntity
import nam.tran.domain.repositories.IAndroidInteractor
import nam.tran.domain.repositories.IEventRepository
import nam.tran.domain.repositories.IRepoRepository
import nam.tran.domain.repositories.IUserRepository
import javax.inject.Inject

class UserUseCase @Inject constructor(private val iAndroidInteractor: IAndroidInteractor
                                      , private val iUserRepository: IUserRepository
                                      , private val iEventRepository: IEventRepository
                                      , private val iRepoRepository: IRepoRepository) {

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

    fun getEvent(page: Int, perPage: Int): Single<List<EventEntity>> {
        return iEventRepository.getEvent(page, perPage)
    }

    fun getRepositories(page: Int, perPage: Int): Single<List<RepositoryEntity>> {
        return iRepoRepository.getRepositories(page, perPage)
    }
}