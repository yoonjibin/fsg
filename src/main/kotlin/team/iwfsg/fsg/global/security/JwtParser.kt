package team.iwfsg.fsg.global.security

import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import jakarta.servlet.http.HttpServletRequest
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import team.iwfsg.fsg.global.security.principle.AuthDetailsService
import java.security.Key

class JwtParser(
        private val securityProperties: SecurityProperties,
        private val authDetailsService: AuthDetailsService
) {
    fun parseAccessToken(request: HttpServletRequest): String? =
            request.getHeader(SecurityProperties.tokenHeader)
                    .let { it ?: return null }
                    .let { if(it.startsWith(SecurityProperties.tokenPrefix)) it.replace(SecurityProperties.tokenPrefix, "") else null }

    fun parseRefreshToken(refreshToken: String): String? =
            if(refreshToken.startsWith(SecurityProperties.tokenPrefix)) refreshToken.replace(SecurityProperties.tokenPrefix, "") else null

    fun authentication(accessToken: String): Authentication =
            authDetailsService.loadUserByUsername(getTokenBody(accessToken, securityProperties.accessSecret).subject)
                    .let { UsernamePasswordAuthenticationToken(it, "", it.authorities) }

    private fun getTokenBody(token: String, secret: Key): Claims =
            Jwts.parserBuilder()
                    .setSigningKey(secret)
                    .build()
                    .parseClaimsJws(token)
                    .body
}