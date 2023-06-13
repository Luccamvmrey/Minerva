package com.example.minerva.data.remote

import com.example.minerva.domain.model.Artwork
import com.example.minerva.domain.model.ArtworkDetail
import retrofit2.http.GET
import retrofit2.http.Path

interface ArtworkAICApi {

    @GET("/v1/artworks?page=1&limit=50&fields=id,title,image_id,artist_title")
    suspend fun getArtworks(): List<Artwork>

    @GET("v1/artworks/{id}?fields=id,title,image_id,alt_text,artist_title,date_display")
    suspend fun getArtworkById(@Path("id") artworkId: String): ArtworkDetail
}