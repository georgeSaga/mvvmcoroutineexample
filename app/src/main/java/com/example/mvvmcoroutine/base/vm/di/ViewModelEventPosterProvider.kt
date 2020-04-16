package com.example.mvvmcoroutine.base.vm.di

import androidx.lifecycle.LiveData
import com.example.mvvmcoroutine.base.event.ViewEvent
import com.example.mvvmcoroutine.base.lifecycle.BufferLiveData
import com.example.mvvmcoroutine.base.vm.EventPoster

object ViewModelEventPosterProvider {

    var provider: () -> EventPoster = {
        object : EventPoster {

            override val viewEvents: LiveData<ViewEvent>
                get() = _viewEvents

            private val _viewEvents = BufferLiveData<ViewEvent>()

            override fun postViewEvents(vararg events: ViewEvent) = events.forEach(_viewEvents::setValue)
        }
    }

    val Default: EventPoster
        get() = provider.invoke()
}