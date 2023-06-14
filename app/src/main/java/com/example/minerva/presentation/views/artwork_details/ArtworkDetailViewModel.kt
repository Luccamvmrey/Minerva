package com.example.minerva.presentation.views.artwork_details

import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.minerva.core.Constants.PARAM_ARTWORK_ID
import com.example.minerva.domain.model.ArtworkDetail
import com.example.minerva.domain.model.ArtworkDetailData
import com.example.minerva.domain.model.Resource.Error
import com.example.minerva.domain.model.Resource.Loading
import com.example.minerva.domain.model.Resource.Success
import com.example.minerva.domain.use_case.get_artwork.GetArtworkUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class ArtworkDetailViewModel @Inject constructor(
    private val getArtworkUseCase: GetArtworkUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = mutableStateOf(ArtworkDetailState())
    val state: State<ArtworkDetailState> = _state

    init {
        savedStateHandle.get<String>(PARAM_ARTWORK_ID)?.let { artworkId ->
            Log.d(TAG, "ArtworkID is $artworkId")
            getArtworkDetail(artworkId)
        }
    }

    private fun getArtworkDetail(artworkId: String) {
        getArtworkUseCase(artworkId).onEach { result ->
            when (result) {
                is Success -> {
                    _state.value = ArtworkDetailState(
                        artwork = result.data ?: ArtworkDetail(ArtworkDetailData())
                    )
                }
                is Error -> {
                    _state.value = ArtworkDetailState(
                        error = result.message ?: "Um erro inesperado ocorreu!"
                    )
                }
                is Loading -> {
                    _state.value = ArtworkDetailState(
                        isLoading = true
                    )
                }
            }
        }.launchIn(viewModelScope)
    }
}