package team.iwfsg.fsg.global.error.exceptions

import team.iwfsg.fsg.global.error.ErrorCode

open class FsgExceptions(val errorCode: ErrorCode) : RuntimeException(errorCode.message)