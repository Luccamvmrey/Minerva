package com.example.minerva.domain.repository

import com.example.minerva.domain.model.Artwork
import com.example.minerva.domain.model.ArtworkDetail

interface ArtworkRepository {
    suspend fun getArtworks(): List<Artwork>

    suspend fun getArtworkById(artworkId: String): ArtworkDetail
}