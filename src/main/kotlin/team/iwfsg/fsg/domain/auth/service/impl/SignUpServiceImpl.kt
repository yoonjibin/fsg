package team.iwfsg.fsg.domain.auth.service.impl


import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import team.iwfsg.fsg.domain.auth.data.dto.SignUpDto
import team.iwfsg.fsg.domain.auth.exception.UserAlreadyExistException
import team.iwfsg.fsg.domain.auth.service.SignUpService
import team.iwfsg.fsg.domain.user.persistence.entity.UserJpaEntity
import team.iwfsg.fsg.domain.user.persistence.repository.UserRepository

@Service
@Transactional(rollbackFor = [Exception::class])
class SignUpServiceImpl(
        private val userRepository: UserRepository,
        private val passwordEncoder: PasswordEncoder
) : SignUpService {

    override fun execute(dto: SignUpDto) {
        val isExist = userRepository.existsByEmail(dto.email)
        if(isExist) {
            throw UserAlreadyExistException()
        }
        userRepository.save(UserJpaEntity(0, dto.name, dto.email, passwordEncoder.encode(dto.password)))
    }
}