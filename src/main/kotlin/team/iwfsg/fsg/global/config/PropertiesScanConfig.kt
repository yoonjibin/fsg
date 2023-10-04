package team.iwfsg.fsg.global.config

import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.context.annotation.Configuration
import team.iwfsg.fsg.global.security.SecurityProperties

@Configuration
@ConfigurationPropertiesScan(
        basePackageClasses = [
            SecurityProperties::class
        ]
)
class PropertiesScanConfig {
}