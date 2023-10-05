package team.iwfsg.fsg.global.security.jwt.impl

import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.stereotype.Component
import team.iwfsg.fsg.domain.auth.persistence.entity.RefreshTokenEntity
import team.iwfsg.fsg.domain.auth.persistence.repository.RefreshTokenRepository
import team.iwfsg.fsg.domain.auth.presentation.data.response.TokenResponse
import team.iwfsg.fsg.global.security.jwt.properties.SecurityProperties
import java.security.Key
import java.time.LocalDateTime
import java.util.*

@Component
class JwtTokenProviderImpl(
        private val securityProperties: SecurityProperties,
        private val refreshTokenRepository: RefreshTokenRepository
) {
    fun generate(userId: Long): TokenResponse {
        val accessToken = generateAccessToken(userId, securityProperties.accessSecret)
        val refreshToken = generateRefreshToken(userId, securityProperties.refreshSecret)
        val accessExpiredAt = getAccessTokenExpiredAt()
        val refreshExpiredAt = getRefreshTokenExpiredAt()
        refreshTokenRepository.save(RefreshTokenEntity(userId = userId, token = refreshToken, expiredAt = securityProperties.refreshExp))
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