package com.example.mvvmapp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.example.mvvmapp.model.ApiService
import com.example.mvvmapp.model.datasource.NewsDataSource

class MainViewModel(apiService: ApiService) : ViewModel() {

    val articles = Pager(PagingConfig(pageSize = 6)) {
        NewsDataSource(apiService)
    }.flow.cachedIn(viewModelScope)
}