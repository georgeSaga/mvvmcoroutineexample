package com.example.mvvmcoroutine.base.net.repository.failure.http

import com.example.mvvmcoroutine.R
import com.example.mvvmcoroutine.base.utils.HttpStatus
import com.example.mvvmcoroutine.base.utils.StringOrResId
import com.example.mvvmcoroutine.base.net.repository.Result

internal object InternalServerError : Result.Failure.HttpError() {
    override val message: StringOrResId = StringOrResId(R.string.err_internal_server)
    override val status: HttpStatus = HttpStatus.INTERNAL_SERVER_ERROR
}