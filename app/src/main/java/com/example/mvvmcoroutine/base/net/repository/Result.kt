package com.example.mvvmcoroutine.base.net.repository

import com.example.mvvmcoroutine.R
import com.example.mvvmcoroutine.base.utils.HttpStatus
import com.example.mvvmcoroutine.base.utils.StringOrResId

sealed class Result<out T> {

    data class Success<out T>(val value: T) : Result<T>()

    abstract class Failure : Result<Nothing>() {

        /** Message that can be shown to user. */
        abstract val message: StringOrResId

        object NetworkUnavailable : Failure() {
            override val message: StringOrResId = StringOrResId(R.string.err_network_connection)
        }

        abstract class HttpError : Failure() {
            abstract val status: HttpStatus
        }

        abstract class ServerInteractionError : Failure() {
            abstract val exception: Throwable
        }
    }
}