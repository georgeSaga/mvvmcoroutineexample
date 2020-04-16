package com.example.mvvmcoroutine.base.extensions

import com.example.mvvmcoroutine.base.net.repository.Result

inline fun <T, R> Result<T>.map(mapper: (T) -> R): Result<R> = when (this) {
    is Result.Success -> Result.Success(mapper.invoke(value))
    is Result.Failure -> this
}

inline fun <T, R> Result<T>.switchMap(mapper: (Result<T>) -> Result<R>): Result<R> = mapper.invoke(this)

fun <T> Result<Result<T>>.flatten(): Result<T> = switchMap {
    when (it) {
        is Result.Success -> it.value
        is Result.Failure -> it
    }
}

inline fun <T> Result<T>.doOnSuccess(block: (T) -> Unit): Result<T> = this.also {
    if (it is Result.Success) block(it.value)
}

inline fun <T> Result<T>.doOnFailure(block: (Result.Failure) -> Unit): Result<T> = this.also {
    if (it is Result.Failure) block(it)
}