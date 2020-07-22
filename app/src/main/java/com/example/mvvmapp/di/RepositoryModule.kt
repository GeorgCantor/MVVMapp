package com.example.mvvmapp.di

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
        pokedexClient: PokedexClient,
        pokemonDao: PokemonDao
    ) = MainRepository(pokedexClient, pokemonDao)

    @Provides
    @ActivityRetainedScoped
    fun provideDetailRepository(
        pokedexClient: PokedexClient,
        pokemonInfoDao: PokemonInfoDao
    ) = DetailRepository(pokedexClient, pokemonInfoDao)
}
