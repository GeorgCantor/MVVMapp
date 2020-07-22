package com.example.mvvmapp.network

import javax.inject.Inject

class ApiClient @Inject constructor(private val service: ApiService) {

    suspend fun fetchPokemonList(page: Int) = service.fetchPokemonList(PAGING_SIZE, page * PAGING_SIZE)

    suspend fun fetchPokemonInfo(name: String) = service.fetchPokemonInfo(name)

    companion object {
        private const val PAGING_SIZE = 20
    }
}
