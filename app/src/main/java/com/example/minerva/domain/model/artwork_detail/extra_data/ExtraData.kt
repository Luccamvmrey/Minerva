package com.example.minerva.domain.model.artwork_detail.extra_data

import com.google.gson.annotations.SerializedName

data class ExtraData(
    @SerializedName("alt_text")
    val altText: String? = "",
    val height: String? = "",
    val lqip: String? = "",
    val width: String? = ""
)