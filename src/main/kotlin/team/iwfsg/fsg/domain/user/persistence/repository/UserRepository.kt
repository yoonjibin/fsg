package team.iwfsg.fsg.domain.user.persistence.repository

import org.springframework.data.repository.CrudRepository
import team.iwfsg.fsg.domain.user.persistence.entity.User

interface UserRepository : CrudRepository<User, Long> {
}