package team.iwfsg.fsg.global.error

enum class ErrorCode(val message: String, val status: Int) {
    FORBIDDEN("FORBIDDEN", 403),
    INTERVAL_SERVER_ERROR("서버 오류 입니다.", 500);
}