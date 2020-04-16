package com.example.mvvmcoroutine.base.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

abstract class BaseViewModelFactory<out T : BaseViewModel> : ViewModelProvider.Factory {

    abstract fun createViewModel(): T

    final override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        val viewModel = createViewModel()

        @Suppress("UNCHECKED_CAST")
        return when (modelClass.isAssignableFrom(viewModel::class.java)) {

            true -> viewModel as T
            else -> throw IllegalArgumentException("incorrect viewModel for factory class = $modelClass")
        }
    }
}