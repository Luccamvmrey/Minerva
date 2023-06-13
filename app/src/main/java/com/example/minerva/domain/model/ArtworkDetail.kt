package com.example.minerva.domain.model

data class ArtworkDetail(
    // I might not need this ID
    val id: String? = null,
    val title: String? = null,
    val imageId: String? = null,
    val altText: String? = null,
    val artistTile: String? = null,
    val dateDisplay: String? = null,
)
