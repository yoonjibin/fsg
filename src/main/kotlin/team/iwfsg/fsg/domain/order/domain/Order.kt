package team.iwfsg.fsg.domain.order.domain

import java.time.LocalDateTime

data class Order(
    val id: Long,
    val userId: Long,
    val productId: Long,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime
)
