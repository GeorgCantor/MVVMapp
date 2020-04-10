package com.example.mvvmapp.di

import androidx.lifecycle.ViewModelProvider
import com.example.mvvmapp.di.base.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module
interface ViewModelFactoryModule {

    @Binds
    fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}