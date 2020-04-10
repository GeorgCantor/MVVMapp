package com.example.mvvmapp.di.module

import com.example.mvvmapp.view.fragment.MainViewModel
import dagger.Module

@Module(includes = [
    ViewModelModule::class,

])
interface FeatureBindingModule {
}