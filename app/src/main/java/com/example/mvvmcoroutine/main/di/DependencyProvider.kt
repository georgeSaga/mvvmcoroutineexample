package com.example.mvvmcoroutine.main.di

import android.app.Application
import android.content.Context
import com.example.mvvmcoroutine.base.net.api.ApiProvider

interface DependencyProvider {

    val apiProvider: ApiProvider

    val appContext: Context

    fun initialize(application: Application)
}