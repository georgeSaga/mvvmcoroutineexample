package com.example.mvvmcoroutine.base.net.repository.failure.http

import com.example.mvvmcoroutine.base.utils.HttpStatus

open class HttpException(
    /** Http status. */
    val status: HttpStatus,
    /** Message that can be shown to user. */
    val userFriendlyMessage: String,
    /** Detailed message about this exception, including [userFriendlyMessage]. */
    detailedMessage: String
) : RuntimeException("HttpException $status : $detailedMessage")