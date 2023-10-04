package team.iwfsg.fsg.global.security.filter

import com.fasterxml.jackson.databind.ObjectMapper
import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.hibernate.validator.internal.util.logging.LoggerFactory
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter
import team.iwfsg.fsg.global.error.ErrorCode
import team.iwfsg.fsg.global.error.ErrorResponse
import team.iwfsg.fsg.global.error.exceptions.FsgException

@Component
class ExceptionFilter(
    private val objectMapper: ObjectMapper
) : OncePerRequestFilter() {

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        try {
            filterChain.doFilter(request, response)
        } catch (e: FsgException) {
            sendError(response, e.errorCode)
        } catch (e: Exception) {
            response.characterEncoding = "UTF-8"
            sendError(response, ErrorCode.INTERNAL_SERVER_ERROR)
        }
    }

    private fun sendError(res: HttpServletResponse, errorCode: ErrorCode) {
        val errorResponse = ErrorResponse(errorCode.message, errorCode.status)
        val responseString = objectMapper!!.writeValueAsString(errorResponse)
        res.status = errorCode.status
        res.contentType = MediaType.APPLICATION_JSON_VALUE
        res.writer.write(responseString)
    }
}