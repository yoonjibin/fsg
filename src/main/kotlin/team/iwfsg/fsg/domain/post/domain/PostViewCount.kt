package team.iwfsg.fsg.domain.post.domain

import team.iwfsg.fsg.global.annotation.Aggregate

@Aggregate
data class PostViewCount(
   val id: Long,
   val ips: Set<String>
)