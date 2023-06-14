package com.example.minerva.presentation.views.artwork_details.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.minerva.domain.model.ArtworkDetailData
import com.example.minerva.presentation.ui.theme.Beige

@Composable
fun ArtworkDetails(
    artwork: ArtworkDetailData
) {
    val title = artwork.title ?: "Unknown Title"
    val artistTitle = artwork.artistTitle ?: "Unknown Artist"
    val dateDisplay = artwork.dateDisplay ?: "Unknown Date"
//    val altText = artwork.altText ?: "No Description Available"

    Text(
        text = title,
        style = TextStyle(
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            color = Beige
        ),
        textAlign = TextAlign.Start
    )
    Text(
        text = artistTitle,
        style = TextStyle(
            fontSize = 18.sp,
            color = Beige
        ),
        textAlign = TextAlign.Start
    )
    Text(
        text = dateDisplay,
        style = TextStyle(
            fontSize = 16.sp,
            color = Beige
        ),
        textAlign = TextAlign.Start
    )
    Spacer(modifier = Modifier.height(24.dp))
//    Text(
//        text = altText,
//        style = TextStyle(
//            fontSize = 18.sp,
//            color = Beige
//        ),
//        textAlign = TextAlign.Justify
//    )
}