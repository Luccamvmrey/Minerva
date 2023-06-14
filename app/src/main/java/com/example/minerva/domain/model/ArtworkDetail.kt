package com.example.minerva.domain.model

import com.google.gson.annotations.SerializedName

data class ArtworkDetail(
    // I might not need this ID
    @SerializedName("id")
    val artworkId: String? = null,
    val title: String? = null,
    @SerializedName("image_id")
    val imageId: String? = null,
    @SerializedName("alt_text")
    val altText: String? = null,
    @SerializedName("artist_title")
    val artistTitle: String? = null,
    @SerializedName("date_display")
    val dateDisplay: String? = null,
)
