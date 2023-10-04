package team.iwfsg.fsg.global.security

import io.jsonwebtoken.security.Keys
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.bind.ConstructorBinding
import java.nio.charset.StandardCharsets

@ConstructorBinding
@ConfigurationProperties(prefix = "jwt")
class SecurityConfig(
   accessSecret: String,
   refreshSecret: String,
   val accessExp: Int,
   val refreshExp: Int
) {
    val accessSecret = Keys.hmacShaKeyFor(accessSecret.toByteArray(StandardCharsets.UTF_8))
    val refreshSecret = Keys.hmacShaKeyFor(accessSecret.toByteArray(StandardCharsets.UTF_8))

    companion object {
        const val accessType = "access"
        const val refreshType = "refresh"
        const val tokenHeader = "Authorization"
        const val tokenPrefix = "Bearer "
    }
}