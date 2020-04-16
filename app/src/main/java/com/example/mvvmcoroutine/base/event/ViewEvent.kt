package com.example.mvvmcoroutine.base.event

import androidx.fragment.app.Fragment

interface ViewEvent {

    fun execute(fragment: Fragment)
}