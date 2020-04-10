package com.example.mvvmapp.view.fragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.mvvmapp.domain.ApiRepository
import com.example.mvvmapp.model.data.Article
import com.example.mvvmapp.view.ViewState
import javax.inject.Inject

class MainViewModel @Inject constructor(repository: ApiRepository) : ViewModel() {

    private val articles: LiveData<ViewState<List<Article>>> = repository.getArticles().asLiveData()

    fun getArticles(): LiveData<ViewState<List<Article>>> = articles
}