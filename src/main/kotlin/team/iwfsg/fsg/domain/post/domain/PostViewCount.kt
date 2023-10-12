package team.iwfsg.fsg.domain.post.domain

import team.iwfsg.fsg.global.annotation.Aggregate

@Aggregate
data class PostViewCount(
   val postId: Long,
   val ips: Set<String>
)