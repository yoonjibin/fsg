package team.iwfsg.fsg.domain.auth.service

import team.iwfsg.fsg.domain.auth.data.dto.SignUpDto

interface SignUpService {
    fun execute(dto: SignUpDto)
}