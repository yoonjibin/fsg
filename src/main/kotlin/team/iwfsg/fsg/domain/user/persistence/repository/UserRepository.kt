package team.iwfsg.fsg.domain.user.persistence.repository

import org.springframework.data.repository.CrudRepository
import team.iwfsg.fsg.domain.user.persistence.entity.UserJpaEntity

interface UserRepository : CrudRepository<UserJpaEntity, Long> {
    fun existsByEmail(email: String): Boolean
}