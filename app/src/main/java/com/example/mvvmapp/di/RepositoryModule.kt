package com.example.mvvmapp.di

import com.example.mvvmapp.db.PokemonDao
import com.example.mvvmapp.db.PokemonInfoDao
import com.example.mvvmapp.network.ApiClient
import com.example.mvvmapp.repository.DetailRepository
import com.example.mvvmapp.repository.MainRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped

@Module
@InstallIn(ActivityRetainedComponent::class)
object RepositoryModule {

    @Provides
    @ActivityRetainedScoped
    fun provideMainRepository(
        client: ApiClient,
        pokemonDao: PokemonDao
    ) = MainRepository(client, pokemonDao)

    @Provides
    @ActivityRetainedScoped
    fun provideDetailRepository(
        client: ApiClient,
        pokemonInfoDao: PokemonInfoDao
    ) = DetailRepository(client, pokemonInfoDao)
}
