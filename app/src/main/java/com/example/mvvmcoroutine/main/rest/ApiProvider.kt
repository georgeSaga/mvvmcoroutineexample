package com.example.mvvmcoroutine.main.rest

import android.content.Context
import com.example.mvvmcoroutine.base.gson.GsonProvider
import com.example.mvvmcoroutine.base.net.api.ApiProvider
import com.example.mvvmcoroutine.base.net.api.BaseApiProvider
import com.example.mvvmcoroutine.base.net.okhttp.OkHttpClientFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class WorkerApiProvider(
    context: Context,
    baseUrl: String
) : BaseApiProvider(),
    ApiProvider {

    private val okHttpClient: OkHttpClient = OkHttpClientFactory.getOkHttpClient(
        context = context,
        timeOutSeconds = TIMEOUT_SECONDS,
        appInterceptors = listOf(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
    )
    override val retrofit: Retrofit

    init {

        val gsonConverterFactory = GsonConverterFactory.create(GsonProvider.gson)

        retrofit = buildRetrofit(baseUrl, okHttpClient, gsonConverterFactory)
    }

    private fun buildRetrofit(
        baseUrl: String,
        client: OkHttpClient,
        converterFactory: GsonConverterFactory
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(converterFactory)
            .client(client)
            .build()
    }
}

private const val TIMEOUT_SECONDS = 30L