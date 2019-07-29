package nam.tran.domain.entities


data class EventEntity(
        val _public: Boolean,
        val actor: ActorEvent,
        val createdAt: String,
        val id: String,
        val payload: PayloadEvent,
        val repo: RepoEvent,
        val type: String
)

data class RepoEvent(
        val id: Int,
        val name: String,
        val url: String
)

data class ActorEvent(
        val avatarUrl: String,
        val displayLogin: String,
        val gravatarId: String,
        val id: Int,
        val login: String,
        val url: String
)

data class PayloadEvent(
        val action: String?
)