package com.example.mvvmapp.model

import com.example.mvvmapp.BuildConfig
import com.example.mvvmapp.model.response.News
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("everything")
    fun getNews(
        @Query("q") query: String,
        @Query("page") page: Int,
        @Query("sortBy") sortBy: String = "publishedAt",
        @Query("language") language: String = "en",
        @Query("apiKey") apiKey: String = BuildConfig.API_KEY
    ): Response<News>
}