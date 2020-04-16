package com.example.mvvmcoroutine.main.rest

import com.example.mvvmcoroutine.main.rest.model.Post
import retrofit2.Call
import retrofit2.http.GET

interface Api {

    @GET("/posts")
    fun getPost(): Call<List<Post>>
}