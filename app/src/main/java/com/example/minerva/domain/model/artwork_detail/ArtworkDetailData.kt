package com.example.minerva.domain.model.artwork_detail

import com.example.minerva.domain.model.artwork_detail.extra_data.ExtraData
import com.google.gson.annotations.SerializedName

data class ArtworkDetailData(
    // I might not need this ID
    @SerializedName("id")
    val artworkId: String? = null,
    val title: String? = null,
    @SerializedName("image_id")
    val imageId: String? = null,
    @SerializedName("artist_title")
    val artistTitle: String? = null,
    @SerializedName("date_display")
    val dateDisplay: String? = null,
    @SerializedName("thumbnail")
    val extraData: ExtraData? = null
)
