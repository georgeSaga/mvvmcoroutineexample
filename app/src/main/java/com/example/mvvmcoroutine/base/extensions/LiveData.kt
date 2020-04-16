package com.example.mvvmcoroutine.base.extensions

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import com.example.mvvmcoroutine.base.lifecycle.observer.DebounceObserver
import com.example.mvvmcoroutine.base.lifecycle.observer.NotNullObserver

fun <T : Any, R : LiveData<T>> R.doOnChanged(owner: LifecycleOwner, onChangedAction: (T) -> Unit): R {

    observe(owner, NotNullObserver(owner, onChangedAction))
    return this
}

fun <T : Any, R : LiveData<T>> R.doOnDebounce(
    owner: LifecycleOwner,
    debounceMs: Long,
    onDebounceAction: (T) -> Unit
): R {

    observe(owner, DebounceObserver<T>(owner, debounceMs, onDebounceAction))
    return this
}