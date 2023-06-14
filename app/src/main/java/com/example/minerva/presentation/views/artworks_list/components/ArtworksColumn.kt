package com.example.minerva.presentation.views.artworks_list.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.minerva.domain.model.Artwork

@Composable
fun ArtworksColumn(
    artworks: List<Artwork>
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(artworks) { artwork ->
            ArtworkCard(
                artwork = artwork
            )
        }
    }
}