package com.example.mvvmcoroutine.base.net.okhttp

import android.content.Context
import com.example.mvvmcoroutine.BuildConfig
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit

object OkHttpClientFactory {

    fun getOkHttpClient(
        context: Context,
        timeOutSeconds: Long,
        appInterceptors: List<Interceptor>
    ): OkHttpClient {

        return OkHttpClient.Builder().apply {

            writeTimeout(timeOutSeconds, TimeUnit.SECONDS)
            readTimeout(timeOutSeconds, TimeUnit.SECONDS)
            appInterceptors.forEach { addInterceptor(it) }
            getLoggingInterceptors(context).forEach { addInterceptor(it) }

        }.build()
    }

    @Suppress("ConstantConditionIf")
    private fun getLoggingInterceptors(context: Context) = arrayListOf<Interceptor>().apply {
        if (BuildConfig.DEBUG) add(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
    }
}