package com.example.mvvmapp

import android.app.Application
import com.example.mvvmapp.di.apiModule
import com.example.mvvmapp.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(listOf(apiModule, viewModelModule))
        }
    }
}