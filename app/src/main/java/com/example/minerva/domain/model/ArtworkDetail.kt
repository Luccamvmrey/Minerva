package com.example.minerva.domain.model

data class ArtworkDetail(
    // I might not need this ID
    val artworkId: String? = null,
    val title: String? = null,
    val imageId: String? = null,
    val altText: String? = null,
    val artistTitle: String? = null,
    val dateDisplay: String? = null,
)
