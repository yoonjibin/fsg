package team.iwfsg.fsg.global.security.exception

import team.iwfsg.fsg.global.error.ErrorCode
import team.iwfsg.fsg.global.error.exceptions.FsgException

class ExpiredTokenException : FsgException(ErrorCode.EXPIRED_TOKEN)