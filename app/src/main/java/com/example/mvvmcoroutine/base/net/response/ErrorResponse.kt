package com.example.mvvmcoroutine.base.net.response

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
internal data class ErrorResponse(@SerializedName("error") val message: String)