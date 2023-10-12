package team.iwfsg.fsg.domain.post.persistence.entity

import org.springframework.data.annotation.Id
import org.springframework.data.redis.core.RedisHash

@RedisHash("post_view_count")
class PostViewCountEntity(
    @Id
    val postId: Long,

    var ips: Set<String>
)
