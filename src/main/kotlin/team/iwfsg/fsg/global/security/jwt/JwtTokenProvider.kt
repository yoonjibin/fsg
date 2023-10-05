package team.iwfsg.fsg.global.security.jwt

import team.iwfsg.fsg.domain.auth.presentation.data.response.TokenResponse

interface JwtTokenProvider {
    fun generate(userId: Long): TokenResponse
}