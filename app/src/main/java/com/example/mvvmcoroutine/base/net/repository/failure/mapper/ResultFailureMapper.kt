package com.example.mvvmcoroutine.base.net.repository.failure.mapper

import com.google.gson.JsonParseException
import com.google.gson.JsonSyntaxException
import com.example.mvvmcoroutine.base.net.repository.Result
import com.example.mvvmcoroutine.base.net.repository.failure.http.*
import com.example.mvvmcoroutine.base.net.repository.failure.http.BadGatewayError
import com.example.mvvmcoroutine.base.net.repository.failure.http.HttpErrorImpl
import com.example.mvvmcoroutine.base.net.repository.failure.http.InternalServerError
import com.example.mvvmcoroutine.base.net.repository.failure.http.ServerNotFoundError
import com.example.mvvmcoroutine.base.net.repository.failure.interaction.ResponseParseError
import com.example.mvvmcoroutine.base.net.repository.failure.interaction.ServerInteractionErrorImpl
import com.example.mvvmcoroutine.base.utils.HttpStatus
import com.example.mvvmcoroutine.base.utils.StringOrResId

internal class ResultFailureMapper : (Throwable) -> Result.Failure {

    override fun invoke(e: Throwable): Result.Failure = when (e) {
        is HttpException -> parseHttpException(e)
        is JsonParseException,
        is JsonSyntaxException -> ResponseParseError(e)
        else -> ServerInteractionErrorImpl(e)
    }

    private fun parseHttpException(e: HttpException): Result.Failure = when (e.status) {
        HttpStatus.NOT_FOUND -> ServerNotFoundError
        HttpStatus.INTERNAL_SERVER_ERROR -> InternalServerError
        HttpStatus.BAD_GATEWAY -> BadGatewayError
        else -> HttpErrorImpl(e.status, StringOrResId(e.userFriendlyMessage))
    }
}