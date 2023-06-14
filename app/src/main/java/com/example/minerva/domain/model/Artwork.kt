package com.example.minerva.domain.model

import com.google.gson.annotations.SerializedName

data class Artwork(
    @SerializedName("id")
    val artworkId: String? = null,
    val title: String? = null,
    @SerializedName("image_id")
    val imageId: String? = null,
    @SerializedName("artist_title")
    val artistTitle: String? = null,
)
