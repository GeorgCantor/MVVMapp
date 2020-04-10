package com.example.mvvmapp.di.module

import androidx.lifecycle.ViewModelProvider
import com.example.mvvmapp.di.base.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module
interface ViewModelFactoryModule {

    @Binds
    fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}