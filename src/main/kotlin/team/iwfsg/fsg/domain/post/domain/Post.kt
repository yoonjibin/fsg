package team.iwfsg.fsg.domain.post.domain

import team.iwfsg.fsg.domain.post.domain.enums.PostType
import team.iwfsg.fsg.global.annotation.Aggregate

@Aggregate
data class Post(
    val id: Long,
    val title: String,
    val content: String,
    val postType: PostType,
    val writerId: Long
)
