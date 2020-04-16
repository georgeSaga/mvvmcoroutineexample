package com.example.mvvmcoroutine.base.utils

import android.content.Context

class StringOrResId : CharSequenceOrResId {

    constructor(stringValue: String) : super(stringValue)
    constructor(stringResId: Int, vararg params: Any) : super(stringResId, *params)

    override fun get(context: Context): String = super.get(context).toString()
}