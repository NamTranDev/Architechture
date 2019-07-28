package nam.tran.data.entities

import com.google.gson.annotations.SerializedName


data class EventEntityData(
        @SerializedName("public")
        val _public: Boolean,
        @SerializedName("actor")
        val actor: ActorEvent,
        @SerializedName("created_at")
        val createdAt: String,
        @SerializedName("id")
        val id: String,
        @SerializedName("payload")
        val payload: PayloadEvent,
        @SerializedName("repo")
        val repo: RepoEvent,
        @SerializedName("type")
        val type: String
)

data class RepoEvent(
        @SerializedName("id")
        val id: Int,
        @SerializedName("name")
        val name: String,
        @SerializedName("url")
        val url: String
)

data class ActorEvent(
        @SerializedName("avatar_url")
        val avatarUrl: String,
        @SerializedName("display_login")
        val displayLogin: String,
        @SerializedName("gravatar_id")
        val gravatarId: String,
        @SerializedName("id")
        val id: Int,
        @SerializedName("login")
        val login: String,
        @SerializedName("url")
        val url: String
)

data class PayloadEvent(
        @SerializedName("action")
        val action: String
)