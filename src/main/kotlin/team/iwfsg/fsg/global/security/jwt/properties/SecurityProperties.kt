package team.iwfsg.fsg.global.security.jwt.properties

import io.jsonwebtoken.security.Keys
import org.springframework.boot.context.properties.ConfigurationProperties
import java.nio.charset.StandardCharsets

@ConfigurationProperties(prefix = "jwt")
class SecurityProperties(
   accessSecret: String,
   refreshSecret: String,
   val accessExp: Int,
   val refreshExp: Int
) {
    val accessSecret = Keys.hmacShaKeyFor(accessSecret.toByteArray(StandardCharsets.UTF_8))
    val refreshSecret = Keys.hmacShaKeyFor(refreshSecret.toByteArray(StandardCharsets.UTF_8))

    companion object {
        const val accessType = "access"
        const val refreshType = "refresh"
        const val tokenHeader = "Authorization"
        const val tokenPrefix = "Bearer "
    }
}