package com.example.mvvmcoroutine.base.extensions

import com.example.mvvmcoroutine.base.gson.GsonProvider
import com.google.gson.JsonParseException
import com.google.gson.JsonSyntaxException
import com.google.gson.reflect.TypeToken


inline fun <reified T> String.fromJson(): T = fromJson(T::class.java)

fun <T> String.fromJson(objClass: Class<T>): T = GsonProvider.gson.fromJson(this, objClass)

fun <T> String.fromJson(typeToken: TypeToken<T>): T = GsonProvider.gson.fromJson(this, typeToken.type)

inline fun <reified T : Any> String.fromJsonOrNull(): T? = fromJsonOrNull(T::class.java)

fun <T : Any> String.fromJsonOrNull(objClass: Class<T>): T? = try {
    fromJson(objClass)
} catch (e: JsonParseException) {
    null
} catch (e: JsonSyntaxException) {
    null
}

inline fun <reified T> String.fromJsonList(): List<T> = fromJson(object : TypeToken<List<T>>() {})