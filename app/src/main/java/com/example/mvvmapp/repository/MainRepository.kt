package com.example.mvvmapp.repository

import com.example.mvvmapp.db.PokemonDao
import com.example.mvvmapp.network.ApiClient
import com.skydoves.sandwich.message
import com.skydoves.sandwich.onError
import com.skydoves.sandwich.onException
import com.skydoves.sandwich.suspendOnSuccess
import com.skydoves.whatif.whatIfNotNull
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val apiClient: ApiClient,
    private val pokemonDao: PokemonDao
) : Repository {

    suspend fun fetchPokemonList(
        page: Int,
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) = flow {
        var pokemons = pokemonDao.getPokemonList(page)
        if (pokemons.isEmpty()) {
            val response = apiClient.fetchPokemonList(page = page)
            response.suspendOnSuccess {
                data.whatIfNotNull { response ->
                    pokemons = response.results
                    pokemons.forEach { pokemon -> pokemon.page = page }
                    pokemonDao.insertPokemonList(pokemons)
                    emit(pokemons)
                    onSuccess()
                }
            }
                .onError { onError(message()) }
                .onException { onError(message()) }
        } else {
            emit(pokemons)
            onSuccess()
        }
    }.flowOn(Dispatchers.IO)
}
