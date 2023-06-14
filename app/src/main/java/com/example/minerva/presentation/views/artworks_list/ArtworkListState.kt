package com.example.minerva.presentation.views.artworks_list

import com.example.minerva.domain.model.Artwork

data class ArtworkListState(
    val isLoading: Boolean = false,
    val artworks: List<Artwork> = emptyList(),
    val error: String = ""
)
