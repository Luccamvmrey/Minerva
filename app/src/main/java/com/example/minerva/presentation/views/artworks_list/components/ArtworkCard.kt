package com.example.minerva.presentation.views.artworks_list.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.minerva.core.Constants.BASE_URL_IMAGE_END
import com.example.minerva.core.Constants.BASE_URL_IMAGE_START
import com.example.minerva.domain.model.Artwork
import com.example.minerva.presentation.ui.theme.Beige
import com.example.minerva.presentation.ui.theme.NaplesYellow

@Composable
fun ArtworkCard(
    artwork: Artwork,
    modifier: Modifier = Modifier,
    onArtworkClick: (Artwork) -> Unit
) {
    val imageUrl = BASE_URL_IMAGE_START + artwork.imageId + BASE_URL_IMAGE_END

    Card(
        modifier = modifier
            .fillMaxWidth()
            .clickable {
                onArtworkClick(artwork)
            },
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        )
    ) {
        Box(
            modifier = Modifier
                .height(200.dp)
        ) {
            //Image
            AsyncImage(
                model = imageUrl,
                contentDescription = artwork.title,
                contentScale = ContentScale.Crop
            )
            //Gradient
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                Color.Black
                            ),
                            startY = 250f
                        )
                    )
            )
            //Text
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(12.dp),
                contentAlignment = Alignment.BottomStart
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.Bottom
                ) {
                    Text(
                        text = artwork.title!!,
                        style = TextStyle(
                            color = Beige,
                            fontSize = 14.sp
                        ),
                        textAlign = TextAlign.Start
                    )
                    Text(
                        text = artwork.artistTitle ?: "Artista desconhecido",
                        style = TextStyle(
                            color = NaplesYellow,
                            fontSize = 12.sp
                        )
                    )
                }
            }
        }
    }
}