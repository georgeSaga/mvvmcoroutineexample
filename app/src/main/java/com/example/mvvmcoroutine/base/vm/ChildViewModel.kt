package com.example.mvvmcoroutine.base.vm

import androidx.annotation.CallSuper
import androidx.lifecycle.LifecycleOwner
import kotlinx.coroutines.CoroutineScope

interface ChildViewModel<T : ChildViewModel.Listener> {

    var listener: T

    @CallSuper
    fun initialize(listener: T) {
        this.listener = listener
    }

    interface Listener : LifecycleOwner, CoroutineScope, EventPoster
}

class ChildViewModelProvider<T : ChildViewModel.Listener> : ChildViewModel<T> {

    override lateinit var listener: T
}