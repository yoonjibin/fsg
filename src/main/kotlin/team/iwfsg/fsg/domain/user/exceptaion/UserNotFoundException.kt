package team.iwfsg.fsg.domain.user.exceptaion

import team.iwfsg.fsg.global.error.ErrorCode
import team.iwfsg.fsg.global.error.exceptions.FsgException

class UserNotFoundException : FsgException(ErrorCode.USER_NOT_FOUND)