package com.example.mvvmapp.di

import com.example.mvvmapp.model.ApiClient
import com.example.mvvmapp.ui.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val apiModule = module {
    single { ApiClient.create() }
}

val viewModelModule = module(override = true) {
    viewModel {
        MainViewModel(get())
    }
}