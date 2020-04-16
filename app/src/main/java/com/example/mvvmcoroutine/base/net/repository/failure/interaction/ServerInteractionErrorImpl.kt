package com.example.mvvmcoroutine.base.net.repository.failure.interaction

import com.example.mvvmcoroutine.R
import com.example.mvvmcoroutine.base.net.repository.Result
import com.example.mvvmcoroutine.base.utils.StringOrResId

/** When used make sure there is no more appropriate error. */
internal class ServerInteractionErrorImpl(override val exception: Throwable) : Result.Failure.ServerInteractionError() {
    override val message: StringOrResId = StringOrResId(R.string.err_network_connection)
}