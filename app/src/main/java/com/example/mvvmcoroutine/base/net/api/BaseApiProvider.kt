package com.example.mvvmcoroutine.base.net.api

import retrofit2.Retrofit

abstract class BaseApiProvider : ApiProvider {

    private val apiMap: HashMap<Class<*>, Any?> = hashMapOf()

    abstract val retrofit: Retrofit

    @Suppress("UNCHECKED_CAST")
    override fun <T> provideApi(apiClass: Class<T>): T =
        (apiMap[apiClass] ?: retrofit.create(apiClass).also { apiMap[apiClass] = it }) as T
}