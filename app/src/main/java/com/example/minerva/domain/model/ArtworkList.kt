package com.example.minerva.domain.model

import com.google.gson.annotations.SerializedName

data class ArtworkList(
    @SerializedName("data")
    val artworks: List<Artwork>
)
