package com.example.mvvmcoroutine.base.vm

import androidx.lifecycle.LiveData
import com.example.mvvmcoroutine.base.event.ViewEvent

interface EventPoster {

    val viewEvents: LiveData<ViewEvent>

    fun postViewEvents(vararg events: ViewEvent)
}