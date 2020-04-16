package com.example.mvvmcoroutine.main.di

import android.app.Application
import android.content.Context
import com.example.mvvmcoroutine.base.gson.GsonProvider
import com.example.mvvmcoroutine.base.net.state.NetStateHelperImpl
import com.example.mvvmcoroutine.base.net.state.NetStateProvider
import com.example.mvvmcoroutine.main.rest.WorkerApiProvider

class DependencyProviderImpl : DependencyProvider {

    override lateinit var appContext: Context
        private set
    override lateinit var apiProvider: WorkerApiProvider
        private set

    override fun initialize(application: Application) {
        appContext = application
        GsonProvider.initialize()
        NetStateProvider.initialize(NetStateHelperImpl(appContext))
        invalidateApi(BASE_URL)
    }

    private fun invalidateApi(apiUrl: String) {
        apiProvider = WorkerApiProvider(appContext, apiUrl)
    }
}

const val BASE_URL: String = "https://jsonplaceholder.typicode.com"