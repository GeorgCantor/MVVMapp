package com.example.mvvmapp.repository

import com.example.mvvmapp.db.PokemonInfoDao
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

class DetailRepository @Inject constructor(
    private val apiClient: ApiClient,
    private val pokemonInfoDao: PokemonInfoDao
) : Repository {

    suspend fun fetchPokemonInfo(
        name: String,
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) = flow {
        val pokemonInfo = pokemonInfoDao.getPokemonInfo(name)
        if (pokemonInfo == null) {
            val response = apiClient.fetchPokemonInfo(name = name)
            response.suspendOnSuccess {
                data.whatIfNotNull { response ->
                    pokemonInfoDao.insertPokemonInfo(response)
                    emit(response)
                    onSuccess()
                }
            }
                .onError { onError(message()) }
                .onException { onError(message()) }
        } else {
            emit(pokemonInfo)
            onSuccess()
        }
    }.flowOn(Dispatchers.IO)
}
