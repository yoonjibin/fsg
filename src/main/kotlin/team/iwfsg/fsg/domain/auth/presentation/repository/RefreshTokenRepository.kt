package team.iwfsg.fsg.domain.auth.presentation.repository

import org.springframework.data.repository.CrudRepository
import team.iwfsg.fsg.domain.auth.presentation.entity.RefreshTokenEntity

interface RefreshTokenRepository : CrudRepository<RefreshTokenEntity, Long> {
}