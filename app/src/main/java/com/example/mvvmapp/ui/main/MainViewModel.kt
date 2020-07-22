package com.example.mvvmapp.ui.main

import androidx.databinding.ObservableBoolean
import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.example.mvvmapp.base.LiveCoroutinesViewModel
import com.example.mvvmapp.model.Pokemon
import com.example.mvvmapp.repository.MainRepository

class MainViewModel @ViewModelInject constructor(
    private val mainRepository: MainRepository,
    @Assisted private val savedStateHandle: SavedStateHandle
) : LiveCoroutinesViewModel() {

    private var pokemonFetchingLiveData: MutableLiveData<Int> = MutableLiveData()
    val pokemonListLiveData: LiveData<List<Pokemon>>
    val isLoading: ObservableBoolean = ObservableBoolean(false)
    val toastLiveData: MutableLiveData<String> = MutableLiveData()

    init {
        pokemonListLiveData = pokemonFetchingLiveData.switchMap {
            isLoading.set(true)
            launchOnViewModelScope {
                this.mainRepository.fetchPokemonList(
                    page = it,
                    onSuccess = { isLoading.set(false) },
                    onError = { toastLiveData.postValue(it) }
                ).asLiveData()
            }
        }
    }

    fun fetchPokemonList(page: Int) {
        pokemonFetchingLiveData.value = page
    }
}
