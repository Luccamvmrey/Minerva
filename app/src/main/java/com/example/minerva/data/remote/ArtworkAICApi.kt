package com.example.minerva.data.remote

import com.example.minerva.domain.model.artwork_detail.ArtworkDetail
import com.example.minerva.domain.model.artwork.ArtworkList
import retrofit2.http.GET
import retrofit2.http.Path

interface ArtworkAICApi {
    @GET("v1/artworks?page=1&limit=50&fields=id,title,image_id,artist_title")
    suspend fun getArtworks(): ArtworkList

    @GET("v1/artworks/{id}?fields=id,title,image_id,alt_text,artist_title,date_display,thumbnail")
    suspend fun getArtworkById(@Path("id") artworkId: String): ArtworkDetail

    @GET("v1/artworks?search?q={query}&page=1&limit=50&fields=id,title,image_id,artist_title")
    suspend fun searchArtworks(@Path("query") query: String): ArtworkList
}