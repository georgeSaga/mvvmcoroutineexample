package com.example.mvvmcoroutine.base.binding

import android.content.res.ColorStateList
import android.view.View
import android.view.ViewGroup
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter

@BindingAdapter("visible")
fun View.setVisible(visible: Boolean) = setVisible(visible, true)

@BindingAdapter("visible", "visibleHideWithGone", requireAll = true)
fun View.setVisible(visible: Boolean, visibleHideWithGone: Boolean) {

    visibility = when {

        visible -> View.VISIBLE
        visibleHideWithGone -> View.GONE
        else -> View.INVISIBLE
    }
}