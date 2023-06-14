package com.example.minerva.presentation.views.artwork_details

import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.minerva.presentation.views.artwork_details.components.ArtworkDetails
import com.example.minerva.presentation.views.artwork_details.components.ArtworkImage
import com.example.minerva.presentation.views.artwork_details.components.TopBarArtworkDetails
import com.example.minerva.presentation.views.components.BackgroundBox
import com.example.minerva.presentation.views.components.ErrorText
import com.example.minerva.presentation.views.components.ProgressBarMinerva

@Composable
fun ArtworkDetailScreen(
    viewModel: ArtworkDetailViewModel = hiltViewModel(),
    navController: NavController
) {
    val state = viewModel.state.value
    Log.d(TAG, "Artwork = ${state.artwork.artwork}")

    Scaffold(
        topBar = {
            TopBarArtworkDetails(
                navController = navController
            )
        }
    ) { contentPadding ->
        Box(
            modifier = Modifier.padding(contentPadding)
        ) {
            BackgroundBox {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(24.dp)
                ) {
                    ArtworkImage(
                        imageId = state.artwork.artwork.imageId!!,
                        artworkTitle = state.artwork.artwork.title!!
                    )
                    Spacer(modifier = Modifier.height(48.dp))
                    ArtworkDetails(
                        artwork = state.artwork.artwork
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
}