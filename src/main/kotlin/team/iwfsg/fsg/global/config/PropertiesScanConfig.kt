package team.iwfsg.fsg.global.config

import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.context.annotation.Configuration
import team.iwfsg.fsg.global.redis.properties.RedisProperties
import team.iwfsg.fsg.global.security.jwt.properties.SecurityProperties

@Configuration
@ConfigurationPropertiesScan(
        basePackageClasses = [
            SecurityProperties::class,
            RedisProperties::class
        ]
)
class PropertiesScanConfig {
}