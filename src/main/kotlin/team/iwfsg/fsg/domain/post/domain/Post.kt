package team.iwfsg.fsg.domain.post.domain

import team.iwfsg.fsg.domain.post.domain.enums.PostType
import team.iwfsg.fsg.global.annotation.Aggregate
import java.time.LocalDateTime

@Aggregate
data class Post(
    val id: Long,
    val title: String,
    val content: String,
    val postType: PostType,
    val createdAt: LocalDateTime,
    val writerId: Long
)
