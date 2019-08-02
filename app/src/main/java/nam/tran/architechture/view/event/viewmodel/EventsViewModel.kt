package nam.tran.architechture.view.event.viewmodel

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.Transformations
import androidx.paging.PagedList
import androidx.paging.toLiveData
import nam.tran.data.Logger
import nam.tran.domain.entities.EventEntity
import nam.tran.domain.interactor.UserUseCase
import tran.nam.core.viewmodel.BaseViewModel
import java.util.concurrent.Executors
import javax.inject.Inject

@SuppressLint("CheckResult")
class EventsViewModel @Inject internal constructor(private val useCase: UserUseCase)
    : BaseViewModel() {

    private val pagedSize = 10
    private val _eventData = MediatorLiveData<PagedList<EventEntity>>()
    val eventData: LiveData<PagedList<EventEntity>>
        get() = _eventData

    private val sourceFactory = EventDataSourceFactory(
            useCase
    )

    val state = Transformations.switchMap(sourceFactory.sourceData) { it.state }

    init {
        val config = PagedList.Config.Builder()
                .setPageSize(pagedSize)
                .setInitialLoadSizeHint(pagedSize * 2)
                .setPrefetchDistance(10)
                .setEnablePlaceholders(false)
                .build()

        _eventData.addSource(sourceFactory.toLiveData(config = config)) {
            Logger.debug(it)
            _eventData.value = it
        }
    }

    fun onRefresh() {
        sourceFactory.sourceData.value?.invalidate()
    }
}
