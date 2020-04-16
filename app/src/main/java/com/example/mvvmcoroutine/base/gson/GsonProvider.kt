package com.example.mvvmcoroutine.base.gson

import com.google.gson.Gson
import com.google.gson.GsonBuilder

object GsonProvider {

    @JvmStatic
    lateinit var gson: Gson
        private set

    @JvmStatic
    @JvmOverloads
    fun initialize(block: GsonBuilder.() -> GsonBuilder = { this }) {
        gson = GsonBuilder()
            .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
            .enableComplexMapKeySerialization()
            .block()
            .create()
    }
}