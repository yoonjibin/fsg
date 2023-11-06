package team.iwfsg.fsg.domain.auth.exception

import team.iwfsg.fsg.global.error.ErrorCode
import team.iwfsg.fsg.global.error.exceptions.FsgException

class UserAlreadyExistException : FsgException(ErrorCode.USER_ALREADY_EXIST)