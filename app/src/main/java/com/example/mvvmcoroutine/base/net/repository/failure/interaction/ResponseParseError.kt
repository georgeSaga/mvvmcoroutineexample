package com.example.mvvmcoroutine.base.net.repository.failure.interaction

import com.example.mvvmcoroutine.R
import com.example.mvvmcoroutine.base.utils.StringOrResId
import com.example.mvvmcoroutine.base.net.repository.Result

internal class ResponseParseError(
    override val exception: Throwable
) : Result.Failure.ServerInteractionError() {
    override val message: StringOrResId = StringOrResId(R.string.err_response_parsing)
}