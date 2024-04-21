package com.anys34.appjam.global.config.error.exception

enum class ErrorCode(
        val status: Int,
        val message: String
) {
    USER_NOT_MATCH(400, "User Not Match"),
    USER_SAME(400, "User Same"),
    USER_INCORRECT(400, "User Incorrect"),
    EXPIRED_JWT(401, "Expired Jwt"),
    INVALID_JWT(401, "Invalid Jwt"),
    USER_NOT_FOUND(404, "User Not Found"),
}