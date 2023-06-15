package com.example.minerva.domain.repository

import com.example.minerva.domain.model.artwork_detail.ArtworkDetail
import com.example.minerva.domain.model.artwork.ArtworkList

interface ArtworkRepository {
    suspend fun getArtworks(): ArtworkList

    suspend fun getArtworkById(artworkId: String): ArtworkDetail
}