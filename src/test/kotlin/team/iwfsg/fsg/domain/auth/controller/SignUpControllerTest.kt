package team.iwfsg.fsg.domain.auth.controller

import io.kotest.core.spec.style.BehaviorSpec
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.springframework.http.HttpStatus
import team.iwfsg.fsg.domain.auth.data.dto.SignUpDto
import team.iwfsg.fsg.domain.auth.mapper.AuthMapper
import team.iwfsg.fsg.domain.auth.presentation.data.request.SignUpRequest
import team.iwfsg.fsg.domain.auth.service.SignUpService

class SignUpControllerTest : BehaviorSpec({
    val authMapper = mockk<AuthMapper>()
    val signUpService = mockk<SignUpService>()

    val authController = AuthController(
            signUpService = signUpService,
            authMapper = authMapper
    )

    Given("회원가입 요청이 들어오면") {
        val name = "test1234"
        val email = "test@gmail.com"
        val password = "test1234"

        val request = SignUpRequest(name, email, password)
        val dto = SignUpDto(name, email, password)


        When("is receive") {
            every { authMapper.mapSignUpRequestToDto(request) } returns dto
            every { signUpService.execute(dto) } returns Unit

            val response = authController.signIn(request)

            then("서비스가 한번은 실행되어야 함") {
                verify(exactly = 1) { signUpService.execute(dto) }
            }

            then("response status should be success") {
                response.statusCode shouldBe HttpStatus.CREATED
            }
        }
    }
})