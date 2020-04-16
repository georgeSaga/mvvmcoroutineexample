package com.example.mvvmcoroutine.base.net.repository.failure.http

import com.example.mvvmcoroutine.R
import com.example.mvvmcoroutine.base.net.repository.Result
import com.example.mvvmcoroutine.base.utils.HttpStatus
import com.example.mvvmcoroutine.base.utils.StringOrResId

internal object ServerNotFoundError : Result.Failure.HttpError() {
    override val message: StringOrResId = StringOrResId(R.string.err_not_found)
    override val status: HttpStatus = HttpStatus.NOT_FOUND
}