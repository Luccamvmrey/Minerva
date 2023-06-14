package com.example.minerva.presentation.views.artwork_details.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.minerva.core.Constants.BASE_URL_IMAGE_END
import com.example.minerva.core.Constants.BASE_URL_IMAGE_START

@Composable
fun ArtworkImage(
    imageId: String,
    artworkTitle: String
) {
    val imageUrl = BASE_URL_IMAGE_START + imageId + BASE_URL_IMAGE_END

    Card(
        modifier = Modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(12.dp)
    ) {
        Box(
            modifier = Modifier
                .height(400.dp),
        ) {
            AsyncImage(
                model = imageUrl,
                contentDescription = artworkTitle,
                contentScale = ContentScale.Crop
            )
        }
    }
}