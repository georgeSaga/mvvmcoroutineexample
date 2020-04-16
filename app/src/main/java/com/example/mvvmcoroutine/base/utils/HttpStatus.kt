package com.example.mvvmcoroutine.base.utils

import retrofit2.Response

enum class HttpStatus(val code: Int) {

    BAD_REQUEST(400),
    UNAUTHORIZED(401),
    FORBIDDEN(403),
    NOT_FOUND(404),
    CONFLICT(409),
    GONE(410),
    UNSUPPORTED_MEDIA_TYPE(415),
    TOO_MANY_REQUESTS(429),
    INTERNAL_SERVER_ERROR(500),
    BAD_GATEWAY(502),
    UNKNOWN(-1)
}

fun Int.toHttpStatus(): HttpStatus = HttpStatus.values().firstOrNull { it.code == this } ?: HttpStatus.UNKNOWN

val Response<*>.status: HttpStatus
    get() = code().toHttpStatus()