package com.example.mvvmcoroutine.base.utils

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class ReadWriteLazy<T : Any>(initializer: () -> T) : ReadWriteProperty<Any?, T> {

    private var initializer: (() -> T)? = initializer

    private var value: T? = null
        get() {

            if (field == null) {
                field = initializer?.invoke()
                initializer = null
            }
            return field
        }

    override fun getValue(thisRef: Any?, property: KProperty<*>): T = value!!

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {

        this.value = value
        initializer = null
    }
}

fun <T : Any> varLazy(initializer: () -> T): ReadWriteProperty<Any?, T> = ReadWriteLazy(initializer)