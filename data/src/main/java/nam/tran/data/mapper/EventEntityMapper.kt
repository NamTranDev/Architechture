package nam.tran.data.mapper

import nam.tran.data.entities.EventEntityData
import nam.tran.domain.entities.ActorEvent
import nam.tran.domain.entities.EventEntity
import nam.tran.domain.entities.PayloadEvent
import nam.tran.domain.entities.RepoEvent

class EventEntityMapper : Mapper<EventEntityData, EventEntity>() {

    override fun mapFrom(e: EventEntityData): EventEntity {
        val repo = RepoEvent(e.repo.id,e.repo.name,e.repo.url)
        val actor = ActorEvent(e.actor.avatarUrl,e.actor.displayLogin,e.actor.gravatarId,e.actor.id,e.actor.login,e.actor.url)
        val payload = PayloadEvent(e.payload.action)
        return EventEntity(e._public,actor,e.createdAt,e.id,payload,repo,e.type)
    }
}