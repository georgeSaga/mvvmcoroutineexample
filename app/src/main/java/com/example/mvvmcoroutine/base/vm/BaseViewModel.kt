package com.example.mvvmcoroutine.base.vm

import androidx.annotation.CallSuper
import androidx.lifecycle.*
import com.example.mvvmcoroutine.base.vm.di.ViewModelCoroutineScopeProvider
import com.example.mvvmcoroutine.base.vm.di.ViewModelEventPosterProvider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.cancel

abstract class BaseViewModel :
    ViewModel(),
    LifecycleObserver,
    LifecycleOwner,
    CoroutineScope by ViewModelCoroutineScopeProvider.Default,
    EventPoster by ViewModelEventPosterProvider.Default,
    ChildViewModel.Listener {

    private val lifecycleRegistry = LifecycleRegistry(this)

    init {
        lifecycleRegistry.currentState = Lifecycle.State.STARTED
    }

    override fun getLifecycle(): Lifecycle = lifecycleRegistry

    @CallSuper
    @ExperimentalCoroutinesApi
    override fun onCleared() {
        super.onCleared()
        lifecycleRegistry.currentState = Lifecycle.State.DESTROYED
        cancel()
    }
}