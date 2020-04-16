package com.example.mvvmcoroutine.base.vm.di

import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlin.coroutines.CoroutineContext

object ViewModelCoroutineScopeProvider {

    var provider: () -> CoroutineScope = {
        object : CoroutineScope {

            override val coroutineContext: CoroutineContext
                get() = Dispatchers.Main + job + exceptionHandler

            private val job = SupervisorJob()

            private val exceptionHandler: CoroutineExceptionHandler = CoroutineExceptionHandler { _, e -> throw e }
        }
    }

    val Default: CoroutineScope
        get() = provider.invoke()
}