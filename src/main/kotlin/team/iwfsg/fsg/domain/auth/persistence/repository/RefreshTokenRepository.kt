package team.iwfsg.fsg.domain.auth.persistence.repository

import org.springframework.data.repository.CrudRepository
import team.iwfsg.fsg.domain.auth.persistence.entity.RefreshTokenEntity

interface RefreshTokenRepository : CrudRepository<RefreshTokenEntity, Long> {
}