package com.example.mvvmapp.di

import com.example.mvvmapp.repository.Repository
import com.example.mvvmapp.view.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val apiModule = module {
//    single { ApiClient.create(get()) }
}

val repositoryModule = module {
    single { Repository() }
}

val viewModelModule = module(override = true) {
    viewModel {
        HomeViewModel(get())
    }
}