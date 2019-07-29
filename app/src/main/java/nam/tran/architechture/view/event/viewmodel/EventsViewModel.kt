package nam.tran.architechture.view.event.viewmodel

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.PagedList
import androidx.paging.RxPagedListBuilder
import io.reactivex.BackpressureStrategy
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import nam.tran.data.Logger
import nam.tran.domain.entities.EventEntity
import nam.tran.domain.interactor.EventUseCase
import tran.nam.core.viewmodel.BaseViewModel

import javax.inject.Inject

@SuppressLint("CheckResult")
class EventsViewModel @Inject internal constructor(private val eventUseCase: EventUseCase)
    : BaseViewModel(){

    private val pagedSize = 10
    private val _eventData = MutableLiveData<PagedList<EventEntity>>()
    val eventData : LiveData<PagedList<EventEntity>>
        get() = _eventData

    private val sourceFactory : EventDataSourceFactory = EventDataSourceFactory(
            eventUseCase,status
    )

    init {
        val config = PagedList.Config.Builder()
                .setPageSize(pagedSize)
                .setInitialLoadSizeHint(pagedSize * 2)
                .setPrefetchDistance(10)
                .setEnablePlaceholders(true)
                .build()

        addDisposable {
            RxPagedListBuilder(sourceFactory, config)
                    .setFetchScheduler(Schedulers.io())
                    .buildObservable()
                    .cache()
                    .subscribe {
                        Logger.debug(it)
                        _eventData.postValue(it)
                    }
        }
    }

    fun onRefresh(){
        sourceFactory.refresh()
    }
}
