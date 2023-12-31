package com.example.minerva.data.remote

import com.example.minerva.domain.model.artwork.ArtworkList
import com.example.minerva.domain.model.artwork_detail.ArtworkDetail
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ArtworkAICApi {
    @GET("v1/artworks?page=1&limit=50&fields=id,title,image_id,artist_title")
    suspend fun getArtworks(): ArtworkList

    @GET("v1/artworks/{id}?fields=id,title,image_id,alt_text,artist_title,date_display,thumbnail")
    suspend fun getArtworkById(@Path("id") artworkId: String): ArtworkDetail

    @GET("v1/artworks/search?")
    suspend fun searchArtworks(
        @Query("q") search: String,
        @Query("limit") limit: String = "50",
        @Query("fields") fields: String = "id,title,image_id,artist_title"
    ): ArtworkList
}
