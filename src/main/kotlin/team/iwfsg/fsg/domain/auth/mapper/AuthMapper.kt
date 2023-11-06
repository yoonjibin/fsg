package team.iwfsg.fsg.domain.auth.mapper

import team.iwfsg.fsg.domain.auth.data.dto.SignUpDto
import team.iwfsg.fsg.domain.auth.presentation.data.request.SignUpRequest
import team.iwfsg.fsg.domain.user.persistence.entity.UserJpaEntity

interface AuthMapper {
    fun mapSignUpRequestToDto(request: SignUpRequest) : SignUpDto
    fun mapSignUpDtoToEntity(dto: SignUpDto, encodedPassword: String) : UserJpaEntity
}