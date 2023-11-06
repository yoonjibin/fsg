package team.iwfsg.fsg.domain.auth.presentation


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
    fun signUp(@RequestBody request: SignUpRequest) : ResponseEntity<Unit> =
            authMapper.mapSignUpRequestToDto(request)
                    .let { signUpService.execute(it) }
                    .let { ResponseEntity.status(HttpStatus.CREATED).build() }
}