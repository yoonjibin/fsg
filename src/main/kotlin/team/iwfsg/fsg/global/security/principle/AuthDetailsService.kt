package team.iwfsg.fsg.global.security.principle

import org.springframework.data.repository.findByIdOrNull
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import team.iwfsg.fsg.domain.user.exceptaion.UserNotFoundException
import team.iwfsg.fsg.domain.user.persistence.repository.UserRepository

@Service
@Transactional(readOnly = true)
class AuthDetailsService(
    private val userRepository: UserRepository
) : UserDetailsService {
    override fun loadUserByUsername(username: String): UserDetails {
        val user = userRepository.findByIdOrNull(username.toLong()) ?: throw UserNotFoundException()
        return AuthDetails(user)
    }
}