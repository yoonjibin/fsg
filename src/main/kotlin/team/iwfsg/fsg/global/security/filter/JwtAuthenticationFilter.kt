package team.iwfsg.fsg.global.security.filter

import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter
import team.iwfsg.fsg.global.security.jwt.JwtParser

@Component
class JwtAuthenticationFilter(
    private val jwtParser: JwtParser
): OncePerRequestFilter() {
    override fun doFilterInternal(
            request: HttpServletRequest,
            response: HttpServletResponse,
            filterChain: FilterChain
    ) {
        val token = jwtParser.parseAccessToken(request)
        if(!token.isNullOrBlank()) {
            val authentication = jwtParser.getAuthentication(token)
            SecurityContextHolder.getContext().authentication = authentication
        }
        filterChain.doFilter(request, response)
    }
}