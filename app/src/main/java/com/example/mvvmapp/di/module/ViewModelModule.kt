package com.example.mvvmapp.di.module

import androidx.lifecycle.ViewModel
import com.example.mvvmapp.di.base.ViewModelKey
import com.example.mvvmapp.view.fragment.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    fun bindMainViewModel(mainViewModel: MainViewModel): ViewModel
}