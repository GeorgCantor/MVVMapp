package com.example.mvvmapp.model

data class Post(
    val id: Int,
    val userName: String,
    val userImageUrl: String,
    val postImageUrl: String,
    val postDescription: String,
    val commentsCount: Int
)