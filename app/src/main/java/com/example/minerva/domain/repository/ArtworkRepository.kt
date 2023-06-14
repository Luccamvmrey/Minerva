package com.example.minerva.domain.repository

import com.example.minerva.domain.model.ArtworkDetail
import com.example.minerva.domain.model.ArtworkList

interface ArtworkRepository {
    suspend fun getArtworks(): ArtworkList

    suspend fun getArtworkById(artworkId: String): ArtworkDetail
}