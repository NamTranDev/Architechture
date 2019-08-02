package nam.tran.architechture.view.event.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import nam.tran.data.Logger
import nam.tran.domain.entities.EventEntity
import nam.tran.domain.interactor.UserUseCase

class EventDataSourceFactory constructor(private val useCase: UserUseCase) : DataSource.Factory<Int, EventEntity>() {

    val sourceData = MutableLiveData<EventDataSource>()

    override fun create(): DataSource<Int, EventEntity> {
        Logger.debug("Paging Learn", "EventDataSourceFactory - create()")
        val source = EventDataSource(useCase)
        sourceData.postValue(source)
        return source
    }
}