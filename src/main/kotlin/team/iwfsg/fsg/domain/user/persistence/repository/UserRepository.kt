package team.iwfsg.fsg.domain.user.persistence.repository

import org.springframework.data.repository.CrudRepository

interface UserRepository : CrudRepository<User, Long> {
}