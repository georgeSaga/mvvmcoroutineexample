package com.example.mvvmcoroutine.base.net.repository.failure.http

import com.example.mvvmcoroutine.base.utils.HttpStatus
import com.example.mvvmcoroutine.base.utils.StringOrResId
import com.example.mvvmcoroutine.base.net.repository.Result

class DetailedApiError(
    override val status: HttpStatus,
    override val message: StringOrResId,
    /** Dynamic typed details. */
    private val details: Any
) : Result.Failure.HttpError() {

    /**
     * Trying to cast this class to some class, using gson reflection.
     * This call cal be compute-intensive! When parsing lists, always use background threads.
     * Each call will invoke up to 2 serializations with reflection.
     */
//    fun <T : Any> parseDetails(toClass: Class<T>): T? = details.toJson().fromJsonOrNull(toClass)
}