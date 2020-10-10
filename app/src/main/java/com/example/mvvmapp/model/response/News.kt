package com.example.mvvmapp.model.response

data class News(
    var status: String,
    var totalResults: Int,
    var articles: List<Article>
)
