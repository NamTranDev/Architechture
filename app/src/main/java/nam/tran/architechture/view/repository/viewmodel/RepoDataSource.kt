package nam.tran.architechture.view.repository.viewmodel

import android.annotation.SuppressLint
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import nam.tran.data.Logger
import nam.tran.data.base.BasePageKeyedDataSource
import nam.tran.data.entities.core.state.ErrorState
import nam.tran.data.entities.core.state.State
import nam.tran.domain.entities.RepositoryEntity
import nam.tran.domain.interactor.UserUseCase

@SuppressLint("CheckResult")
class RepoDataSource constructor(private val useCase: UserUseCase)
    : BasePageKeyedDataSource<RepositoryEntity>() {
    override fun getData(isLoadMore: Boolean, page: Int, countItem: Int, callback: (List<RepositoryEntity>, Int, Int?) -> Unit): Disposable {
        if (isLoadMore) {
            return useCase.getRepositories(page, countItem)
                    .subscribeOn(Schedulers.io())
                    .doOnSubscribe {
                        Logger.debug("Loading")
                        state.postValue(State.loadingPaging())
                    }
                    .subscribe({
                        Logger.debug("success")
                        state.postValue(State.successPaging())
                        if (isLoadMore)
                            callback.invoke(it, page + 1, null)
                        else
                            callback.invoke(it, 1, 2)
                    }, {
                        Logger.debug("error")
                        state.postValue(State.errorPaging(ErrorState.getErrorMessage(it), retry = {
                            getData(isLoadMore, page, countItem, callback)
                        }))
                    })
        } else {
            return useCase.getRepositories(page, countItem).doOnSubscribe {
                Logger.debug("Loading")
                state.postValue(State.loading(hasRefresh = true))
            }
                    .subscribe({
                        Logger.debug("success")
                        state.postValue(State.success())
                        if (isLoadMore)
                            callback.invoke(it, page + 1, null)
                        else
                            callback.invoke(it, 1, 2)
                    }, {
                        Logger.debug("error")
                        state.postValue(State.error(ErrorState.getErrorMessage(it), retry = {
                            invalidate()
                        }))
                    })
        }
    }
}