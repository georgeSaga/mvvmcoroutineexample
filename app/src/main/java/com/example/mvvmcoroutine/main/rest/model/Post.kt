package com.example.mvvmcoroutine.main.rest.model

data class Post(
    val userId: Int,
    val id: Int,
    val title: String,
    val body: String
)