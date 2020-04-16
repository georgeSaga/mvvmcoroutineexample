package com.example.mvvmcoroutine.base.net.repository.error

import com.example.mvvmcoroutine.base.extensions.fromJsonOrNull
import com.example.mvvmcoroutine.base.net.repository.failure.http.HttpException
import com.example.mvvmcoroutine.base.utils.toHttpStatus
import com.example.mvvmcoroutine.base.net.response.ErrorResponse
import retrofit2.Response

internal class ErrorParserImpl : ErrorParser {

    override fun parse(response: Response<*>): Nothing {
        val wrappedResponse = ErrorResponseWrapper(response)
        wrappedResponse.parseLegacyOrDefaultHttpError()
    }

    private fun ErrorResponseWrapper.parseLegacyOrDefaultHttpError(): Nothing {
        val message = getLegacyErrorOrNull()?.message ?: this.message
        throw HttpException(
            status = code.toHttpStatus(),
            userFriendlyMessage = message,
            detailedMessage = "$message, code = $code"
        )
    }

    private fun ErrorResponseWrapper.getLegacyErrorOrNull(): ErrorResponse? = body.fromJsonOrNull()

    /**
     * Convinient wrapper for error response.
     * Because reading response.errorBody().string() can be done only once -
     *   https://github.com/square/retrofit/issues/1321#issuecomment-251160231
     */
    private class ErrorResponseWrapper(
        val code: Int,
        val message: String,
        val body: String
    ) {
        constructor(retrofitResponse: Response<*>) : this(
            code = retrofitResponse.code(),
            message = retrofitResponse.message(),
            body = retrofitResponse.errorBody().string()
        )
    }
}