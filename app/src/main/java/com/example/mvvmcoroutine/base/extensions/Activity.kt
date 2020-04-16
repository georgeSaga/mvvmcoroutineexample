package com.example.mvvmcoroutine.base.extensions

import android.app.Activity
import com.example.mvvmcoroutine.main.di.DependencyProvider

val Activity.appProvider: DependencyProvider
    get() = application.appProvider