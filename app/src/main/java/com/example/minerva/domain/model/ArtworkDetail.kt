package com.example.minerva.domain.model

import com.google.gson.annotations.SerializedName

data class ArtworkDetail(
    @SerializedName("data")
    val artwork: ArtworkDetailData
)
