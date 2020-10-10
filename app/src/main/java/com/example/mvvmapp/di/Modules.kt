package com.example.mvvmapp.di

import org.koin.dsl.module

val apiModule = module {
//    single { ApiClient.create(get()) }
}

val viewModelModule = module(override = true) {
}