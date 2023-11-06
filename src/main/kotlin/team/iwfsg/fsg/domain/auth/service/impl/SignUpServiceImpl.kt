package team.iwfsg.fsg.domain.auth.service.impl


import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import team.iwfsg.fsg.domain.auth.data.dto.SignUpDto
import team.iwfsg.fsg.domain.auth.exception.UserAlreadyExistException
import team.iwfsg.fsg.domain.auth.mapper.AuthMapper
import team.iwfsg.fsg.domain.auth.service.SignUpService
import team.iwfsg.fsg.domain.user.persistence.repository.UserRepository

@Service
@Transactional(rollbackFor = [Exception::class])
class SignUpServiceImpl(
        private val userRepository: UserRepository,
        private val passwordEncoder: PasswordEncoder,
        private val authMapper: AuthMapper
) : SignUpService {

    override fun execute(dto: SignUpDto) {
        if(userExists(dto.email)) {
            throw UserAlreadyExistException()
        }

        saveUser(dto)
    }

    private fun userExists(email: String) =
        userRepository.existsByEmail(email)

    private fun saveUser(dto: SignUpDto) {
        val encodedPassword = passwordEncoder.encode(dto.password)

        val userEntity = authMapper.mapSignUpDtoToEntity(
                dto = dto,
                encodedPassword = encodedPassword
        )

        userRepository.save(userEntity)
    }
}