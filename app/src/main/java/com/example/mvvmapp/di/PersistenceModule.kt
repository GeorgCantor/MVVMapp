package com.example.mvvmapp.di

import android.app.Application
import androidx.room.Room
import com.example.mvvmapp.db.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PersistenceModule {

    @Provides
    @Singleton
    fun provideAppDatabase(application: Application) = Room
        .databaseBuilder(application, AppDatabase::class.java, "Pokedex.db")
        .fallbackToDestructiveMigration()
        .build()

    @Provides
    @Singleton
    fun providePokemonDao(appDatabase: AppDatabase) = appDatabase.pokemonDao()

    @Provides
    @Singleton
    fun providePokemonInfoDao(appDatabase: AppDatabase) = appDatabase.pokemonInfoDao()
}
