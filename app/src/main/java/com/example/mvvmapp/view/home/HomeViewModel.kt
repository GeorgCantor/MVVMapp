package com.example.mvvmapp.view.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmapp.model.Post
import com.example.mvvmapp.repository.Repository
import kotlinx.coroutines.launch

class HomeViewModel(repository: Repository) : ViewModel() {

    val posts = MutableLiveData<List<Post>>()

    init {
        viewModelScope.launch {
            repository.getPosts().apply {
                posts.postValue(this)
            }
        }
    }
}