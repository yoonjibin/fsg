package team.iwfsg.fsg.domain.auth.presentation


import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import team.iwfsg.fsg.domain.auth.mapper.AuthMapper
import team.iwfsg.fsg.domain.auth.presentation.data.request.SignUpRequest
import team.iwfsg.fsg.domain.auth.service.SignUpService
import team.iwfsg.fsg.global.annotation.RequestController

@RequestController("/auth")
class AuthController(
    private val signUpService: SignUpService,
    private val authMapper: AuthMapper
) {
    @PostMapping("/sign-up")
    @Operation(summary = "회원 가입", description = "유저 회원가입")
    @ApiResponses(
            value = [
                ApiResponse(
                        responseCode = "201", description = "회원가입 성공"
                ),
                ApiResponse(
                        responseCode = "400", description = "요청값이 올바르지 않을 경우",
                        content = [Content(schema = Schema(implementation = String::class))]
                ),
                ApiResponse(
                        responseCode = "409", description = "유저가 이미 존재하는 경우",
                        content = [Content(schema = Schema(implementation = String::class))]
                )
            ]
    )
    fun signUp(@RequestBody request: SignUpRequest) : ResponseEntity<Unit> =
            authMapper.mapSignUpRequestToDto(request)
                    .let { signUpService.execute(it) }
                    .let { ResponseEntity.status(HttpStatus.CREATED).build() }
}