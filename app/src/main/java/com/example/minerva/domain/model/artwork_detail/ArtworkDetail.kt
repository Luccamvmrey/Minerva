package com.example.minerva.domain.model.artwork_detail

import com.google.gson.annotations.SerializedName

data class ArtworkDetail(
    @SerializedName("data")
    val artwork: ArtworkDetailData
)
