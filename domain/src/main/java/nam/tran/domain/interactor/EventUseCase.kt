package nam.tran.domain.interactor

import io.reactivex.Single
import nam.tran.domain.entities.EventEntity
import nam.tran.domain.repositories.IEventRepository
import javax.inject.Inject

class EventUseCase @Inject constructor(private val iEventRepository: IEventRepository){

    fun getEvent(page: Int): Single<List<EventEntity>> {
        return iEventRepository.getEvent(page)
    }
}