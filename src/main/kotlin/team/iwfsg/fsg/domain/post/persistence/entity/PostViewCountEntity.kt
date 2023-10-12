package team.iwfsg.fsg.domain.post.persistence.entity

import org.springframework.data.annotation.Id
import org.springframework.data.redis.core.RedisHash

@RedisHash("post-view-count")
data class PostViewCountEntity(
    @Id
    val postId: Long,

    var ips: Set<String>
)
