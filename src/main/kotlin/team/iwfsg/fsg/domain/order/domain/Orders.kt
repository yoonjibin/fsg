package team.iwfsg.fsg.domain.order.domain

import team.iwfsg.fsg.global.annotation.Aggregate
import java.time.LocalDateTime

@Aggregate
data class Orders(
    val id: Long,
    val userId: Long,
    val productId: Long,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime
)
