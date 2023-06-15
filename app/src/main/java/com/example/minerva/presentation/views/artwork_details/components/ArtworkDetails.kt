package com.example.minerva.presentation.views.artwork_details.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.minerva.domain.model.artwork_detail.ArtworkDetailData
import com.example.minerva.presentation.ui.theme.Beige
import com.example.minerva.presentation.ui.theme.DeepBlue

@Composable
fun ArtworkDetails(
    artwork: ArtworkDetailData
) {
    val title = artwork.title ?: "Unknown Title"
    val artistTitle = artwork.artistTitle ?: "Unknown Artist"
    val dateDisplay = artwork.dateDisplay ?: "Unknown Date"
    val altText = artwork.extraData?.altText ?: "No Description Available"

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .border(1.dp, Beige, shape = RoundedCornerShape(12.dp))
            .padding(14.dp)
            .background(DeepBlue)
    ) {
        Column {
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
            Spacer(modifier = Modifier.height(16.dp))
            Divider(color = Beige)
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = altText,
                style = TextStyle(
                    fontSize = 16.sp,
                    color = Beige
                ),
                textAlign = TextAlign.Justify
            )
        }
    }
}