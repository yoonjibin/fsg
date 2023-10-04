package team.iwfsg.fsg.global.security.exception

import team.iwfsg.fsg.global.error.ErrorCode
import team.iwfsg.fsg.global.error.exceptions.FsgException

class InvalidTokenException : FsgException(ErrorCode.INVALID_TOKEN)