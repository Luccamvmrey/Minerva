package com.example.minerva.data.repository

import com.example.minerva.data.remote.ArtworkAICApi
import com.example.minerva.domain.model.artwork_detail.ArtworkDetail
import com.example.minerva.domain.model.artwork.ArtworkList
import com.example.minerva.domain.repository.ArtworkRepository
import javax.inject.Inject

class ArtworkRepositoryImpl @Inject constructor(
    private val api: ArtworkAICApi
) : ArtworkRepository {
    override suspend fun getArtworks(): ArtworkList {
        return api.getArtworks()
    }

    override suspend fun getArtworkById(artworkId: String): ArtworkDetail {
        return api.getArtworkById(artworkId)
    }
}