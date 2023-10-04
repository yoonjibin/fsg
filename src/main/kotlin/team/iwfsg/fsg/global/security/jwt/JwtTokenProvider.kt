package team.iwfsg.fsg.global.security.jwt

import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import team.iwfsg.fsg.global.security.jwt.properties.SecurityProperties
import java.security.Key
import java.time.LocalDateTime
import java.util.*

class JwtTokenProvider(
        private val securityProperties: SecurityProperties
) {
    fun generate(userId: Long): TokenResponse {
        val accessToken = generateAccessToken(userId, securityProperties.accessSecret)
        val refreshToken = generateRefreshToken(userId, securityProperties.refreshSecret)
        val accessExpiredAt = getAccessTokenExpiredAt()
        val refreshExpiredAt = getRefreshTokenExpiredAt()
        // TODO 리프레쉬 토큰 저장 로직 구현 - 윤지빈
        return TokenResponse(accessToken, refreshToken, accessExpiredAt, refreshExpiredAt)
    }

    private fun generateAccessToken(userId: Long, secret: Key): String =
            Jwts.builder()
                    .signWith(secret, SignatureAlgorithm.HS256)
                    .setSubject(userId.toString())
                    .claim("type", SecurityProperties.accessType)
                    .setIssuedAt(Date())
                    .setExpiration(Date(System.currentTimeMillis() + securityProperties.accessExp * 1000))
                    .compact()

    private fun generateRefreshToken(userId: Long, secret: Key): String =
            Jwts.builder()
                    .signWith(secret, SignatureAlgorithm.HS256)
                    .setSubject(userId.toString())
                    .claim("type", SecurityProperties.refreshType)
                    .setIssuedAt(Date())
                    .setExpiration(Date(System.currentTimeMillis() + securityProperties.accessExp * 1000))
                    .compact()

    private fun getAccessTokenExpiredAt(): LocalDateTime =
            LocalDateTime.now().plusSeconds(securityProperties.accessExp.toLong())

    private fun getRefreshTokenExpiredAt(): LocalDateTime =
            LocalDateTime.now().plusSeconds(securityProperties.refreshExp.toLong())
}