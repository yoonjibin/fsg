package team.iwfsg.fsg.global.error

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import team.iwfsg.fsg.global.error.exceptions.FsgException

@RestControllerAdvice
class GlobalExceptionHandler {
    @ExceptionHandler(FsgException::class)
    fun globalExceptionHandler(e:FsgException) : ResponseEntity<ErrorResponse> =
        ResponseEntity(
            ErrorResponse(status = e.errorCode.status, message = e.errorCode.message),
            HttpStatus.valueOf(e.errorCode.status)
        )
}