package nam.tran.data.repositories

import io.reactivex.Single
import nam.tran.data.local.IPreference
import nam.tran.data.mapper.EventEntityMapper
import nam.tran.data.network.IApi
import nam.tran.domain.entities.EventEntity
import nam.tran.domain.repositories.IEventRepository
import javax.inject.Inject

class EventRepository @Inject constructor(private val iPreference: IPreference, private val iApi: IApi) : IEventRepository {

    override fun getEvent(page: Int,perPage : Int) : Single<List<EventEntity>> {
        return iApi.getEvent(iPreference.user,page,perPage).map {
            val mapper = EventEntityMapper()
            mapper.mapFrom(it)
        }
    }

}