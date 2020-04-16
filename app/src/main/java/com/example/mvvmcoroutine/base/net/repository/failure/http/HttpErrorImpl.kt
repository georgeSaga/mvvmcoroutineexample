package com.example.mvvmcoroutine.base.net.repository.failure.http

import com.example.mvvmcoroutine.base.utils.HttpStatus
import com.example.mvvmcoroutine.base.utils.StringOrResId
import com.example.mvvmcoroutine.base.net.repository.Result

internal class HttpErrorImpl(
    override val status: HttpStatus,
    override val message: StringOrResId
) : Result.Failure.HttpError()