package com.example.mvvmcoroutine.base.net.repository

import com.example.mvvmcoroutine.base.net.repository.error.ErrorParser
import com.example.mvvmcoroutine.base.net.repository.error.ErrorParserImpl
import com.example.mvvmcoroutine.base.net.repository.failure.mapper.ResultFailureMapper
import com.example.mvvmcoroutine.base.net.state.NetStateProvider
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Response

abstract class BaseRepository {

    protected open val failureMapper: (Throwable) -> Result.Failure = ResultFailureMapper()
    protected open val errorParser: ErrorParser = ErrorParserImpl()

    protected suspend fun <T> request(call: Call<T>): Result<T> = execute {
        when (NetStateProvider.netState.isNetworkConnected()) {
            true -> parseResponse(call.execute())
            false -> Result.Failure.NetworkUnavailable
        }
    }

    private suspend fun <T> execute(body: suspend () -> Result<T>): Result<T> = withContext(IO) {
        try {
            body()
        } catch (e: Throwable) {
            failureMapper.invoke(e)
        }
    }

    protected open fun <T> parseResponse(response: Response<T>): Result<T> = when (response.isSuccessful) {
        true -> Result.Success(response.body())
        false -> errorParser.parse(response)
    }
}