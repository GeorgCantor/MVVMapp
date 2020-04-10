package com.example.mvvmapp.model.data

data class NewsResponse(
    val status: String = "",
    val source: String = "",
    val sortBy: String = "",
    val articles: List<Article> = emptyList()
)