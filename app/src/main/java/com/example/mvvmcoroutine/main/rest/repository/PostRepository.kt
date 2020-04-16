package com.example.mvvmcoroutine.main.rest.repository

import com.example.mvvmcoroutine.base.net.repository.BaseRepository
import com.example.mvvmcoroutine.main.rest.Api
import com.example.mvvmcoroutine.main.rest.model.Post
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import com.example.mvvmcoroutine.base.net.repository.Result

class PostRepository(private val api: Api) : BaseRepository() {
    suspend fun getPosts(): Result<List<Post>> = withContext(Dispatchers.IO) {
        request(api.getPost())
    }
}