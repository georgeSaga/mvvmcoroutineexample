package com.example.mvvmcoroutine.base.lifecycle.observer

import androidx.lifecycle.LifecycleOwner
import com.example.mvvmcoroutine.base.vm.di.ViewModelCoroutineScopeProvider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

internal class DebounceObserver<T : Any>(

    lifecycleOwner: LifecycleOwner,
    private val debounceMs: Long,
    private val onDebounceAction: (T) -> Unit

) : LifecycleLiveDataObserver<T>(lifecycleOwner), CoroutineScope {

    override val coroutineContext = ViewModelCoroutineScopeProvider.Default.coroutineContext

    private var job: Job? = null

    override fun onChanged(value: T?) {

        value ?: return
        job?.cancel()
        job = launch {
            delay(debounceMs)
            onDebounceAction.invoke(value)
        }
    }

    override fun onDestroy(lifecycleOwner: LifecycleOwner) {
        super.onDestroy(lifecycleOwner)

        job?.cancel()
    }
}