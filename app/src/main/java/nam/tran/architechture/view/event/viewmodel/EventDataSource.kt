package nam.tran.architechture.view.event.viewmodel

import android.annotation.SuppressLint
import androidx.databinding.ObservableField
import androidx.paging.PageKeyedDataSource
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import nam.tran.data.Logger
import nam.tran.data.entities.core.state.ErrorState
import nam.tran.data.entities.core.state.Loading
import nam.tran.data.entities.core.state.State
import nam.tran.domain.entities.EventEntity
import nam.tran.domain.interactor.EventUseCase

@SuppressLint("CheckResult")
class EventDataSource constructor(private val eventUseCase: EventUseCase, private var state: ObservableField<State>) : PageKeyedDataSource<Int, EventEntity>() {

    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, EventEntity>) {
        state.set(State.loading())
        eventUseCase.getEvent(1, params.requestedLoadSize)
                .subscribeOn(Schedulers.io())
                .subscribe({
                    state.set(State.success())
                    callback.onResult(it, 1, 2)
                }, {
                    Logger.debug("error")
                    state.set(State.error(ErrorState.getErrorMessage(it), loading = Loading.LOADING_DIALOG, retry = {
                        loadInitial(params, callback)
                    }))
                })
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, EventEntity>) {
        state.set(State.loadingPaging())
        eventUseCase.getEvent(params.key, params.requestedLoadSize)
                .subscribeOn(Schedulers.io())
                .subscribe({
                    state.set(State.successPaging())
                    callback.onResult(it, params.key + 1)
                }, {
                    state.set(State.errorPaging(ErrorState.getErrorMessage(it), retry = {
                        loadAfter(params, callback)
                    }))
                })
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, EventEntity>) {

    }
}