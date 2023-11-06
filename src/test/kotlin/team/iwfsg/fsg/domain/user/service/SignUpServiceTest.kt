package team.iwfsg.fsg.domain.user.service

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.ints.exactly
import io.mockk.*
import team.iwfsg.fsg.domain.auth.persistence.repository.RefreshTokenRepository
import team.iwfsg.fsg.domain.user.persistence.repository.UserRepository
import team.iwfsg.fsg.global.security.jwt.JwtTokenProvider

class SignUpServiceTest: BehaviorSpec({
    val name = "test1234"
    val email = "test@gmail.com"
    val password = "test1234"

    val tokenProvider = mockk<JwtTokenProvider>()
    val userRepository = mockk<UserRepository>()
    val repositoryRepository = mockk<RefreshTokenRepository>()

    Given("회원가입에 필요한 정보들이 주어졌을 때") {
        val request = SignUpDto(name, email, password)
        When("회원가입을 시도할 때") {
            And("동일한 이메일로 가입한 사용자가 없다면") {
                beforeTest {
                    every { userRepository.existsByEmail(email) } returns false
                    every { userRepository.save(any()) }
                }

                Then("가입이 완료되어야한다.") {
                    verify(exactly = 1) { userRepository.existsByEmail(email) }
                    verify(exactly = 1) { userRepository.save(any()) }
                }
            }
            And("동일한 이메일로 가입한 사용자가 있다면") {
                beforeTest {
                    every { userRepository.existsByEmail(email) } returns true
                    every { userRepository.save(any()) }
                }

                Then("유저가 저장되지 않고 오류가 발생해야한다.") {
                    shouldThrow<UserAlreadyExistsException> {
                        SignUpService.execute(signUpDto)
                    }
                }
            }
        }
    }
})