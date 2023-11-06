package team.iwfsg.fsg.domain.user.domain

import team.iwfsg.fsg.global.annotation.Aggregate

@Aggregate
data class User(
    val id: Long,
    val name: String,
    val email: String,
    val password: String,
)
