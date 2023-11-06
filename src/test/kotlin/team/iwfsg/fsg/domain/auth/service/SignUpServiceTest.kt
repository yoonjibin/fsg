package team.iwfsg.fsg.domain.auth.service

import io.kotest.core.spec.style.BehaviorSpec
import io.mockk.*
import org.junit.jupiter.api.assertThrows
import org.springframework.security.crypto.password.PasswordEncoder
import team.iwfsg.fsg.domain.auth.data.dto.SignUpDto
import team.iwfsg.fsg.domain.auth.exception.UserAlreadyExistException
import team.iwfsg.fsg.domain.auth.mapper.AuthMapper
import team.iwfsg.fsg.domain.auth.service.impl.SignUpServiceImpl
import team.iwfsg.fsg.domain.user.persistence.entity.UserJpaEntity
import team.iwfsg.fsg.domain.user.persistence.repository.UserRepository

class SignUpServiceTest: BehaviorSpec({
    val userRepository = mockk<UserRepository>()
    val passwordEncoder = mockk<PasswordEncoder>()
    val authMapper = mockk<AuthMapper>()
    val signUpService = SignUpServiceImpl(userRepository = userRepository,
            passwordEncoder = passwordEncoder,
            authMapper = authMapper
    )

    Given("회원가입에 필요한 정보들이 주어졌을 때") {
        val name = "test1234"
        val email = "test@gmail.com"
        val password = "test1234"
        val encodedPassword = "encodedPassword"
        val userEntity = UserJpaEntity(0, name, email, password)


        val dto = SignUpDto(name, email, password)
        When("존재하지 않는 회원이 회원가입을 시도할 때") {
            And("동일한 이메일로 가입한 사용자가 없다면") {
                every { signUpService.execute(dto) } just runs

                every { userRepository.existsByEmail(email) } returns false
                every { passwordEncoder.encode(password) } returns encodedPassword
                every { authMapper.mapSignUpDtoToEntity(dto, encodedPassword) } returns  userEntity
                every { userRepository.save(any<UserJpaEntity>()) } returns UserJpaEntity(0, name, email, password)

                Then("가입이 완료되어야 한다.") {
                    signUpService.execute(dto)
                    verify(exactly = 1) { userRepository.existsByEmail(email) }
                    verify(exactly = 1) { userRepository.save(any<UserJpaEntity>()) }
                }
            }
            And("동일한 이메일로 가입한 사용자가 있다면") {
                every { signUpService.execute(dto) } just runs

                every { userRepository.existsByEmail(email) } returns true

                Then("UserAlreadyExistException이 발생해야한다.") {
                    assertThrows<UserAlreadyExistException> {
                        signUpService.execute(dto)
                    }
                }
            }
        }
    }
})