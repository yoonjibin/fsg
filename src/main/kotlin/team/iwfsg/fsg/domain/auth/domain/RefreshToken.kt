package team.iwfsg.fsg.domain.auth.domain

import team.iwfsg.fsg.global.annotation.Aggregate

@Aggregate
data class RefreshToken(
    val userId: Long,
    val token: String,
    val expiredAt: Int
)