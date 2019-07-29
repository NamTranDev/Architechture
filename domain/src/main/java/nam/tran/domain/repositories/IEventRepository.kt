package nam.tran.domain.repositories

import io.reactivex.Single
import nam.tran.domain.entities.EventEntity

interface IEventRepository {
    fun getEvent(page: Int,perPage : Int): Single<List<EventEntity>>
}