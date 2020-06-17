package com.example.mvvmapp.model

data class Post(
    val id: Int,
    val userName: String,
    val userImageUrl: String,
    val postImages: List<String>,
    val likes: Int,
    val postDescription: String,
    val commentsCount: Int
)