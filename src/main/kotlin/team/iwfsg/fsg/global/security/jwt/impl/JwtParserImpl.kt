package team.iwfsg.fsg.global.security.jwt.impl

import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import jakarta.servlet.http.HttpServletRequest
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Component
import team.iwfsg.fsg.global.security.jwt.JwtParser
import team.iwfsg.fsg.global.security.jwt.properties.SecurityProperties
import team.iwfsg.fsg.global.security.principle.AuthDetailsService
import java.security.Key

@Component
class JwtParserImpl(
        private val securityProperties: SecurityProperties,
        private val authDetailsService: AuthDetailsService
) : JwtParser {
    override fun parseAccessToken(request: HttpServletRequest): String? =
            request.getHeader(SecurityProperties.tokenHeader)
                    .let { it ?: return null }
                    .let { if(it.startsWith(SecurityProperties.tokenPrefix)) it.replace(SecurityProperties.tokenPrefix, "") else null }

    override fun parseRefreshToken(refreshToken: String): String? =
            if(refreshToken.startsWith(SecurityProperties.tokenPrefix)) refreshToken.replace(SecurityProperties.tokenPrefix, "") else null

    override fun getAuthentication(accessToken: String): Authentication =
            authDetailsService.loadUserByUsername(getTokenBody(accessToken, securityProperties.accessSecret).subject)
                    .let { UsernamePasswordAuthenticationToken(it, "", it.authorities) }

    private fun getTokenBody(token: String, secret: Key): Claims =
            Jwts.parserBuilder()
                    .setSigningKey(secret)
                    .build()
                    .parseClaimsJws(token)
                    .body
}