package com.example.mvvmcoroutine.base.lifecycle

import androidx.lifecycle.MutableLiveData

class NotNullLiveData<T : Any>(initialValue: T) : MutableLiveData<T>() {

    init {

        value = initialValue
    }

    override fun getValue(): T = super.getValue()!!

    @Suppress("REDUNDANT_OVERRIDING") // T? replaced with T
    override fun setValue(value: T) = super.setValue(value)
}