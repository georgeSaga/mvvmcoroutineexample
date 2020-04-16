package com.example.mvvmcoroutine.base.net.api

interface ApiProvider {

    fun <T> provideApi(apiClass: Class<T>): T
}

inline fun <reified T> ApiProvider.provideApi(): T = provideApi(T::class.java)