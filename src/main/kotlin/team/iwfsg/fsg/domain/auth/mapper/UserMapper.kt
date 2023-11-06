package team.iwfsg.fsg.domain.auth.mapper

import team.iwfsg.fsg.domain.auth.data.dto.SignUpDto
import team.iwfsg.fsg.domain.user.persistence.entity.UserJpaEntity

interface UserMapper {
    fun mapSignUpDtoToEntity(dto: SignUpDto, encodedPassword: String) : UserJpaEntity

}