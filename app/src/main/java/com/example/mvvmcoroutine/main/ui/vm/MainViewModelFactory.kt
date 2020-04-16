package com.example.mvvmcoroutine.main.ui.vm

import com.example.mvvmcoroutine.base.net.api.provideApi
import com.example.mvvmcoroutine.base.vm.BaseViewModelFactory
import com.example.mvvmcoroutine.main.di.DependencyProvider
import com.example.mvvmcoroutine.main.rest.repository.PostRepository

class MainViewModelFactory(
    private val appProvider: DependencyProvider
) : BaseViewModelFactory<MainViewModel>() {
    override fun createViewModel(): MainViewModel {
        return MainViewModel(
            postRepository = PostRepository(appProvider.apiProvider.provideApi())
        )
    }
}