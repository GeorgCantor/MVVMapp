package com.example.mvvmapp.domain

import com.example.mvvmapp.model.data.Article
import com.example.mvvmapp.view.ViewState
import kotlinx.coroutines.flow.Flow

interface ApiRepository {

    fun getArticles(): Flow<ViewState<List<Article>>>
}