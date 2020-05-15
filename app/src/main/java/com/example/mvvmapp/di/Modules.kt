package com.example.mvvmapp.di

import org.koin.dsl.module

val apiModule = module {
//    single { ApiClient.create(get()) }
}

val repositoryModule = module {
//    single { ApiRepository(get(), get()) }
}

val viewModelModule = module(override = true) {
//    viewModel {
//        AuthPhoneViewModel(androidApplication(), get())
//    }
}