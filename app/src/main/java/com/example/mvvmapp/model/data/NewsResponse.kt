package com.example.mvvmapp.model.data

import com.google.gson.annotations.SerializedName

data class NewsResponse(
    val status: String = "",
    val source: String = "",
    val sortBy: String = "",
    val articles: List<Articles> = emptyList()
)