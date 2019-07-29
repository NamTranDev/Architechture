package nam.tran.architechture.view.event.viewmodel

import androidx.databinding.ObservableField
import androidx.paging.DataSource
import nam.tran.data.Logger
import nam.tran.data.entities.core.state.State
import nam.tran.domain.entities.EventEntity
import nam.tran.domain.interactor.EventUseCase

class EventDataSourceFactory constructor(private val eventUseCase: EventUseCase, private var state : ObservableField<State>) : DataSource.Factory<Int, EventEntity>() {

    private lateinit var source : EventDataSource

    override fun create(): DataSource<Int, EventEntity> {
        Logger.debug("create")
        source = EventDataSource(eventUseCase, state)
        return source
    }

    fun refresh() = source.invalidate()
}