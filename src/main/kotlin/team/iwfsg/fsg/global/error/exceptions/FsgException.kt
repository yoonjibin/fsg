package team.iwfsg.fsg.global.error.exceptions

import team.iwfsg.fsg.global.error.ErrorCode

open class FsgException(val errorCode: ErrorCode) : RuntimeException(errorCode.message)