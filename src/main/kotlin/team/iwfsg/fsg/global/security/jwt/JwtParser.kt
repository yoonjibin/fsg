package team.iwfsg.fsg.global.security.jwt

import jakarta.servlet.http.HttpServletRequest
import org.springframework.security.core.Authentication

interface JwtParser {
    fun parseAccessToken(request: HttpServletRequest): String?
    fun parseRefreshToken(refreshToken: String): String?
    fun getAuthentication(accessToken: String): Authentication
}