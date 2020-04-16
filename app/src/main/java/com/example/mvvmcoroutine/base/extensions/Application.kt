package com.example.mvvmcoroutine.base.extensions

import android.app.Application
import com.example.mvvmcoroutine.MyApplication
import com.example.mvvmcoroutine.main.di.DependencyProvider

inline val Application.appProvider: DependencyProvider
    get() = (this as MyApplication).dependencyProvider