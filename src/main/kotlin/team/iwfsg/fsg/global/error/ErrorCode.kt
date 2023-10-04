package team.iwfsg.fsg.global.error

enum class ErrorCode(val message: String, val status: Int) {
    EXPIRED_TOKEN("expired token", 401),
    UNAUTHORIZED("unauthorized",401),
    FORBIDDEN("forbidden", 403),
    USER_NOT_FOUND("user not found", 404),
    INTERVAL_SERVER_ERROR("internal server error", 500);
}