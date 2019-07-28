package nam.tran.architechture.view.event.viewmodel

import android.annotation.SuppressLint
import androidx.databinding.ObservableField
import androidx.paging.PageKeyedDataSource
import nam.tran.data.entities.core.state.ErrorState
import nam.tran.data.entities.core.state.State
import nam.tran.domain.entities.EventEntity
import nam.tran.domain.interactor.EventUseCase

@SuppressLint("CheckResult")
class EventDataSource constructor(private val eventUseCase: EventUseCase, private var state : ObservableField<State>) : PageKeyedDataSource<Int, EventEntity>() {

    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, EventEntity>) {
        eventUseCase.getEvent(1).subscribe({
            callback.onResult(it,1,params.requestedLoadSize)
        }, {
            state.set(State.error(ErrorState.getErrorMessage(it),retry = {
                loadInitial(params,callback)
            }))
        })
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, EventEntity>) {
        eventUseCase.getEvent(1).subscribe({
            callback.onResult(it,params.key + params.requestedLoadSize)
        }, {
            state.set(State.error(ErrorState.getErrorMessage(it),retry = {
                loadAfter(params,callback)
            }))
        })
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, EventEntity>) {

    }
}