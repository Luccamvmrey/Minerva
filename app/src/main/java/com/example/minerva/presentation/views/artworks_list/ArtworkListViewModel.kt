package com.example.minerva.presentation.views.artworks_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.minerva.domain.model.artwork.ArtworkList
import com.example.minerva.domain.model.Resource.Error
import com.example.minerva.domain.model.Resource.Loading
import com.example.minerva.domain.model.Resource.Success
import com.example.minerva.domain.use_case.get_artworks.GetArtworksUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class ArtworkListViewModel @Inject constructor(
    private val getArtworksUseCase: GetArtworksUseCase
) : ViewModel() {

    private val _state = mutableStateOf(ArtworkListState())
    val state: State<ArtworkListState> = _state

    init {
        getArtworks()
    }

    fun getArtworks() {
        getArtworksUseCase().onEach { result ->
            when (result) {
                is Success -> {
                    _state.value = ArtworkListState(
                        artworks = result.data ?: ArtworkList(emptyList())
                    )
                }
                is Error -> {
                    _state.value = ArtworkListState(
                        error = result.message ?: "Um erro inesperado ocorreu!"
                    )
                }
                is Loading -> {
                    _state.value = ArtworkListState(
                        isLoading = true
                    )
                }
            }
        }.launchIn(viewModelScope)
    }
}