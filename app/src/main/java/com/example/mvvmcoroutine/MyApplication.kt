package com.example.mvvmcoroutine

import android.app.Application
import com.example.mvvmcoroutine.base.gson.GsonProvider
import com.example.mvvmcoroutine.main.di.DependencyProvider
import com.example.mvvmcoroutine.main.di.DependencyProviderImpl

class MyApplication : Application() {

    lateinit var dependencyProvider: DependencyProvider

    override fun onCreate() {
        super.onCreate()
        dependencyProvider = initDependencies()
    }

    private fun initDependencies(): DependencyProvider {
        return DependencyProviderImpl().also { it.initialize(this) }
    }
}