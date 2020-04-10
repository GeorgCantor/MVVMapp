package com.example.mvvmapp.model.remote

import com.example.mvvmapp.model.data.NewsResponse
import com.example.mvvmapp.BuildConfig
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("articles?source=google-news&apiKey=${BuildConfig.NEWS_API_KEY}")
    suspend fun getNews(): Response<NewsResponse>
}