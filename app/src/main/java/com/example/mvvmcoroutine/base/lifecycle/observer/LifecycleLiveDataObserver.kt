package com.example.mvvmcoroutine.base.lifecycle.observer

import androidx.lifecycle.*

internal abstract class LifecycleLiveDataObserver<T>(

    lifecycleOwner: LifecycleOwner

) : Observer<T>, LifecycleObserver {

    init {

        lifecycleOwner.lifecycle.addObserver(this)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    open fun onDestroy(lifecycleOwner: LifecycleOwner) {

        lifecycleOwner.lifecycle.removeObserver(this)
    }
}