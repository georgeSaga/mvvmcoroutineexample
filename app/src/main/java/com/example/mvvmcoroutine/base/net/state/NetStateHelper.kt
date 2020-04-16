package com.example.mvvmcoroutine.base.net.state

import android.content.Context
import android.net.ConnectivityManager

interface NetStateHelper {

    fun isNetworkConnected(): Boolean
}

class NetStateHelperImpl(private val appContext: Context) : NetStateHelper {

    override fun isNetworkConnected(): Boolean =
        (appContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager)
            .activeNetworkInfo?.isConnected ?: false
}