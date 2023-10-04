package team.iwfsg.fsg.domain.auth.presentation.data.response

import java.time.LocalDateTime

data class TokenResponse(
    val accessToken: String,
    val refreshToken: String,
    val accessExp: LocalDateTime,
    val refreshExp: LocalDateTime
)
