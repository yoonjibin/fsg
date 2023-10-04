package team.iwfsg.fsg.domain.auth.presentation.entity

import org.springframework.data.annotation.Id
import org.springframework.data.redis.core.RedisHash
import org.springframework.data.redis.core.TimeToLive
import org.springframework.data.redis.core.index.Indexed
import java.util.concurrent.TimeUnit

@RedisHash(value = "refresh_token")
data class RefreshTokenEntity(
    @Id
    val userIdx: Long,
    @Indexed
    val token: String,
    @TimeToLive(unit = TimeUnit.SECONDS)
    val expiredAt: Int
)