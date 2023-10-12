package team.iwfsg.fsg.domain.post.domain

import team.iwfsg.fsg.global.annotation.Aggregate

@Aggregate
data class Category(
   val id: Long,
   val content: String,
   val postId: Long
)
