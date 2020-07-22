package com.example.mvvmapp.di

import com.skydoves.sandwich.coroutines.CoroutinesResponseCallAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideOkHttpClient() = OkHttpClient.Builder()
        .addInterceptor(HttpRequestInterceptor())
        .build()

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient) = Retrofit.Builder()
        .client(okHttpClient)
        .baseUrl("https://pokeapi.co/api/v2/")
        .addConverterFactory(MoshiConverterFactory.create())
        .addCallAdapterFactory(CoroutinesResponseCallAdapterFactory())
        .build()

    @Provides
    @Singleton
    fun providePokedexService(retrofit: Retrofit) = retrofit.create(PokedexService::class.java)

    @Provides
    @Singleton
    fun providePokedexClient(pokedexService: PokedexService) = PokedexClient(pokedexService)
}
