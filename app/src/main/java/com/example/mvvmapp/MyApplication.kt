package com.example.mvvmapp

import android.app.Application
import com.example.mvvmapp.di.apiModule
import com.example.mvvmapp.di.repositoryModule
import com.example.mvvmapp.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MyApplication)
            modules(arrayListOf(apiModule, repositoryModule, viewModelModule))
        }
    }
}