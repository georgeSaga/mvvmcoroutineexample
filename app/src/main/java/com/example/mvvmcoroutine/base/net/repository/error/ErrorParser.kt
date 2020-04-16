package com.example.mvvmcoroutine.base.net.repository.error

import retrofit2.Response

interface ErrorParser {
    fun parse(response: Response<*>): Nothing
}