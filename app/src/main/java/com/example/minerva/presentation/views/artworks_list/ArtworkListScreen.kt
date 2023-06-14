package com.example.minerva.presentation.views.artworks_list

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.minerva.presentation.views.artworks_list.components.ArtworksColumn
import com.example.minerva.presentation.views.artworks_list.components.TopBarArtworksList
import com.example.minerva.presentation.views.components.BackgroundBox
import com.example.minerva.presentation.views.components.ErrorText
import com.example.minerva.presentation.views.components.ProgressBarMinerva

@Composable
fun ArtworkListScreen(
    viewModel: ArtworkListViewModel = hiltViewModel(),
    navController: NavController
) {
    val state = viewModel.state.value

    Scaffold(
        topBar = {
            TopBarArtworksList()
        }
    ) { contentPadding ->
        Box(
            modifier = Modifier.padding(contentPadding)
        ) {
            BackgroundBox {
                ArtworksColumn(
                    artworks = state.artworks.artworks,
                    navController = navController
                )
                if (state.error.isNotBlank()) {
                    ErrorText(
                        errorMessage = state.error
                    )
                }
                if (state.isLoading) {
                    ProgressBarMinerva()
                }
            }
        }
    }
}