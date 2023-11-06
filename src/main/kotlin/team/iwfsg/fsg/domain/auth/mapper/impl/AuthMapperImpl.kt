package team.iwfsg.fsg.domain.auth.mapper.impl

import org.springframework.stereotype.Component
import team.iwfsg.fsg.domain.auth.data.dto.SignUpDto
import team.iwfsg.fsg.domain.auth.mapper.AuthMapper
import team.iwfsg.fsg.domain.user.persistence.entity.UserJpaEntity

@Component
class AuthMapperImpl : AuthMapper {
    override fun mapSignUpDtoToEntity(dto: SignUpDto, encodedPassword: String): UserJpaEntity =
        UserJpaEntity(
                id = 0,
                name = dto.name,
                email = dto.email,
                password = encodedPassword
        )

}