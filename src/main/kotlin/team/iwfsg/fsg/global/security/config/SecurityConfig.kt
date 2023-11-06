package team.iwfsg.fsg.global.security.config

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain
import team.iwfsg.fsg.global.security.handler.CustomAuthenticationEntryPoint
import team.iwfsg.fsg.global.security.jwt.JwtParser

@Configuration
@EnableWebSecurity
class SecurityConfig(
        private val jwtParser: JwtParser,
        private val objectMapper: ObjectMapper,
) {
    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
         http
                .cors{it.disable()}
                .csrf{it.disable()}
                .formLogin{it.disable()}
                .httpBasic{it.disable()}
                .sessionManagement{it.sessionCreationPolicy(SessionCreationPolicy.STATELESS)}

                .authorizeHttpRequests{
                    it.requestMatchers(HttpMethod.POST, "/auth/sign-up").permitAll()
                    it.anyRequest().denyAll()
                }
                .exceptionHandling{
                    it.authenticationEntryPoint(CustomAuthenticationEntryPoint(objectMapper))
                }
        http
                .apply(FilterConfig(jwtParser, objectMapper))
        return http.build()
    }
    @Bean
    fun passwordEncoder(): PasswordEncoder? = BCryptPasswordEncoder()
}