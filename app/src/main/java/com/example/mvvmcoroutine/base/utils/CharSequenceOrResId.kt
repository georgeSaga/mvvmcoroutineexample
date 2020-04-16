package com.example.mvvmcoroutine.base.utils

import android.content.Context

open class CharSequenceOrResId private constructor() {

    private var charSequence: CharSequence? = null
    private var charSequenceResId: Int = -1
    private var params: Array<*>? = null

    constructor(charSequenceValue: CharSequence) : this() {
        this.charSequence = charSequenceValue
    }

    constructor(dataResId: Int, vararg params: Any) : this() {
        this.charSequenceResId = dataResId
        this.params = params
    }

    @SuppressWarnings("UseIfInsteadOfWhen")
    open fun get(context: Context): CharSequence = when {
        charSequence != null -> charSequence!!
        else -> getDataFromRes(context, charSequenceResId, params)
    }

    @SuppressWarnings("SpreadOperator", "UseIfInsteadOfWhen")
    protected open fun getDataFromRes(context: Context, dataResId: Int, params: Array<*>?): CharSequence =
        when {
            params.isNullOrEmpty() -> context.resources.getText(dataResId)
            else -> context.resources.getString(dataResId, *params)
        }

    /** toString for debugging */
    override fun toString() =
        "${javaClass.simpleName} :\nvalue = $charSequence\nid= $charSequenceResId\nparams = $params"
}