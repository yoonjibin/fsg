package team.iwfsg.fsg.global.error

enum class ErrorCode(val message: String, val status: Int) {
    EXPIRED_TOKEN("expired token", 401),
    INVALID_TOKEN("invalid token",401),
    FORBIDDEN("forbidden", 403),
    USER_NOT_FOUND("user not found", 404),
    USER_ALREADY_EXIST("user already exist", 409),
    INTERNAL_SERVER_ERROR("internal server error", 500);
}