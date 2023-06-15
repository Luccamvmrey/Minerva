package com.example.minerva.presentation.views.artworks_list.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.minerva.domain.model.artwork.Artwork
import com.example.minerva.presentation.navigation.Screen

@Composable
fun ArtworksColumn(
    artworks: List<Artwork>,
    gridCellsState: Int,
    navController: NavController
) {
    val filteredArtworks = artworks.filter { artwork ->
        artwork.imageId != null
    }

    LazyVerticalGrid(
        columns = GridCells.Fixed(gridCellsState),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)

    ) {
        items(filteredArtworks) { artwork ->
            ArtworkCard(
                artwork = artwork,
                gridCellsState = gridCellsState,
                onArtworkClick = {
                    navController.navigate(
                        Screen.ArtworkDetailScreen.route + "/${artwork.artworkId}"
                    )
                }
            )
        }
    }
}