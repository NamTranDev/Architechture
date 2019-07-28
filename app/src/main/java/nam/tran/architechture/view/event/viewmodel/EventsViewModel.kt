package nam.tran.architechture.view.event.viewmodel

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.PagedList
import androidx.paging.RxPagedListBuilder
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

    private val pagedSize = 20
    private val _eventData = MutableLiveData<PagedList<EventEntity>>()
    val eventData : LiveData<PagedList<EventEntity>>
        get() = _eventData
    init {
        val sourceFactory = EventDataSourceFactory(
                eventUseCase,status
        )
        val config = PagedList.Config.Builder()
                .setPageSize(pagedSize)
                .setInitialLoadSizeHint(pagedSize * 3)
                .setPrefetchDistance(10)
                .setEnablePlaceholders(false)
                .build()

        addDisposable {
            RxPagedListBuilder(sourceFactory, config)
                    .setFetchScheduler(Schedulers.io())
                    .buildObservable()
                    .cache().observeOn(AndroidSchedulers.mainThread())
                    .subscribe({
                        _eventData.value = it
                    },{
                        Logger.debug(it)
                    })
        }
    }
}
