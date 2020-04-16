package com.example.mvvmcoroutine.base.net.state

object NetStateProvider {

    @JvmStatic
    lateinit var netState: NetStateHelper
        private set

    fun initialize(netState: NetStateHelper) {
        this.netState = netState
    }
}