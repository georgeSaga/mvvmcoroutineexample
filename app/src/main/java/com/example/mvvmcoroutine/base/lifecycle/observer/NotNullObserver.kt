package com.example.mvvmcoroutine.base.lifecycle.observer

import androidx.lifecycle.LifecycleOwner

internal class NotNullObserver<T : Any>(

    owner: LifecycleOwner,
    private val onChangedAction: (T) -> Unit

) : LifecycleLiveDataObserver<T>(owner) {

    override fun onChanged(t: T?) {
        t?.let(onChangedAction)
    }
}