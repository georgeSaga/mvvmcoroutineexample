package com.example.mvvmcoroutine.main.ui.vm

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.OnLifecycleEvent
import com.example.mvvmcoroutine.base.event.ViewEventShowToast
import com.example.mvvmcoroutine.base.extensions.doOnFailure
import com.example.mvvmcoroutine.base.extensions.doOnSuccess
import com.example.mvvmcoroutine.base.lifecycle.NotNullLiveData
import com.example.mvvmcoroutine.base.vm.BaseViewModel
import com.example.mvvmcoroutine.main.rest.repository.PostRepository
import kotlinx.coroutines.launch

class MainViewModel(
    val postRepository: PostRepository
) : BaseViewModel() {

    val postTitle = NotNullLiveData("")
    val postBody = NotNullLiveData("")
    val progressVisible = NotNullLiveData(false)

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun initialize() {
        launch {
            progressVisible.value = true
            postRepository.getPosts()
                .doOnSuccess {
                    postTitle.value = it.firstOrNull()?.title ?: ""
                    postBody.value = it.firstOrNull()?.body ?: ""
                }
                .doOnFailure {
                    postViewEvents(ViewEventShowToast(it.message))
                }
            progressVisible.value = false
        }
    }
}