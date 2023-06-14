package com.example.minerva.presentation.views.artworks_list.components

import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.foundation.gestures.detectTransformGestures
import androidx.compose.foundation.gestures.rememberTransformableState
import androidx.compose.foundation.gestures.transformable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.minerva.domain.model.Artwork
import com.example.minerva.presentation.navigation.Screen

@Composable
fun ArtworksColumn(
    artworks: List<Artwork>,
    navController: NavController
) {
    val filteredArtworks = artworks.filter { artwork ->
        artwork.imageId != null
    }

    var gridCellNumber by remember {
        mutableIntStateOf(2)
    }

    Box(
        modifier = Modifier
            .pointerInput(Unit) {
                detectTransformGestures { _, _, zoom, _ ->

                    gridCellNumber = when {
                        zoom < 0f -> 2
                        zoom > 0f -> 1
                        else -> gridCellNumber
                    }
                }
            }
    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(gridCellNumber),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp)

        ) {
            items(filteredArtworks) { artwork ->
                ArtworkCard(
                    artwork = artwork,
                    onArtworkClick = {
                        navController.navigate(
                            Screen.ArtworkDetailScreen.route + "/${artwork.artworkId}"
                        )
                    }
                )
            }
        }
    }

}