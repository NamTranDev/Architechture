package nam.tran.data.mapper

import nam.tran.data.entities.UserEntityData
import nam.tran.domain.entities.UserEntity

class UserEntityMapper : Mapper<UserEntityData, UserEntity>() {

    override fun mapFrom(e: UserEntityData): UserEntity {
        return UserEntity(
                e.avatarUrl,
                e.bio,
                e.blog,
                e.company,
                e.createdAt,
                e.email,
                e.eventsUrl,
                e.followers,
                e.followersUrl,
                e.following,
                e.followingUrl,
                e.gistsUrl,
                e.gravatarId,
                e.htmlUrl,
                e.id,
                e.location,
                e.login,
                e.name,
                e.nodeId,
                e.organizationsUrl,
                e.publicGists,
                e.publicRepos,
                e.receivedEventsUrl,
                e.reposUrl,
                e.siteAdmin,
                e.starredUrl,
                e.subscriptionsUrl,
                e.type,
                e.updatedAt,
                e.url
        )
    }
}