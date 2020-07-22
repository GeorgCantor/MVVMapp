package com.example.mvvmapp.ui.details

import androidx.databinding.ObservableBoolean
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.switchMap
import com.example.mvvmapp.base.LiveCoroutinesViewModel
import com.example.mvvmapp.model.PokemonInfo
import com.example.mvvmapp.repository.DetailRepository

class DetailsViewModel @ViewModelInject constructor(
    private val detailRepository: DetailRepository
) : LiveCoroutinesViewModel() {

    private var pokemonFetchingLiveData: MutableLiveData<String> = MutableLiveData()
    val pokemonInfoLiveData: LiveData<PokemonInfo?>
    val isLoading: ObservableBoolean = ObservableBoolean(false)
    val toastLiveData: MutableLiveData<String> = MutableLiveData()

    init {
        pokemonInfoLiveData = pokemonFetchingLiveData.switchMap {
            isLoading.set(true)
            launchOnViewModelScope {
                this.detailRepository.fetchPokemonInfo(
                    name = it,
                    onSuccess = { isLoading.set(false) },
                    onError = { toastLiveData.postValue(it) }
                ).asLiveData()
            }
        }
    }

    fun fetchPokemonInfo(name: String) {
        pokemonFetchingLiveData.value = name
    }
}
