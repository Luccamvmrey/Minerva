package com.example.minerva.presentation.views.artworks_list

import com.example.minerva.domain.model.artwork.ArtworkList

data class ArtworkListState(
    val isLoading: Boolean = false,
    val artworks: ArtworkList = ArtworkList(emptyList()),
    val error: String = "",
    val isRefreshing: Boolean = false
)
