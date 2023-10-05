package team.iwfsg.fsg.global.redis

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.connection.RedisConnectionFactory
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.data.redis.core.ZSetOperations
import team.iwfsg.fsg.global.redis.properties.RedisProperties

@Configuration
class RedisConfig(
        private val redisProperties: RedisProperties,
) {
    @Bean
    fun redisConnectionFactory(): RedisConnectionFactory =
            LettuceConnectionFactory(redisProperties.host, redisProperties.port)

    @Bean
    fun redisTemplate(): RedisTemplate<String, Any> {
        val redisTemplate: RedisTemplate<String, Any> = RedisTemplate()
        redisTemplate.connectionFactory = redisConnectionFactory()
        return redisTemplate
    }

    @Bean
    fun zSetOperation(): ZSetOperations<String, Any> =
            redisTemplate().opsForZSet()
}