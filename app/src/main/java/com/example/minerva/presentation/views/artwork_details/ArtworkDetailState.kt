package com.example.minerva.presentation.views.artwork_details

import com.example.minerva.domain.model.ArtworkDetail
import com.example.minerva.domain.model.ArtworkDetailData

data class ArtworkDetailState(
    val isLoading: Boolean = false,
    val artwork: ArtworkDetail = ArtworkDetail(
        ArtworkDetailData(
            artworkId = "",
            title = "",
            imageId = "",
            altText = "",
            artistTitle = "",
            dateDisplay = ""
        )
    ),
    val error: String = ""
)
