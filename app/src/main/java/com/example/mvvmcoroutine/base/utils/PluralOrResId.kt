package com.example.mvvmcoroutine.base.utils

import android.content.Context

class PluralOrResId : CharSequenceOrResId {

    private var quantity: Int = -1

    constructor(charSequenceValue: CharSequence) : super(charSequenceValue)
    constructor(stringResId: Int, quantity: Int, vararg params: Any) : super(stringResId, *params) {
        this.quantity = quantity
    }

    @SuppressWarnings("SpreadOperator", "UseIfInsteadOfWhen")
    override fun getDataFromRes(context: Context, dataResId: Int, params: Array<*>?): CharSequence =
        when {
            params.isNullOrEmpty() -> context.resources.getQuantityText(dataResId, quantity)
            else -> context.resources.getQuantityString(dataResId, quantity, *params)
        }

    override fun toString(): String = "${super.toString()}\nquantity=$quantity"
}