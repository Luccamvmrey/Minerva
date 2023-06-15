package com.example.minerva.presentation.views.artwork_details

import com.example.minerva.domain.model.artwork_detail.ArtworkDetail
import com.example.minerva.domain.model.artwork_detail.ArtworkDetailData

data class ArtworkDetailState(
    val isLoading: Boolean = false,
    val artwork: ArtworkDetail = ArtworkDetail(
        ArtworkDetailData(
            artworkId = "",
            title = "",
            imageId = "",
            artistTitle = "",
            dateDisplay = "",
        )
    ),
    val error: String = ""
)
