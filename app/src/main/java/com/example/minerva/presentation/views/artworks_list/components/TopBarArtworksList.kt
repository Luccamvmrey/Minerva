package com.example.minerva.presentation.views.artworks_list.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.GridView
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.minerva.presentation.ui.theme.Beige
import com.example.minerva.presentation.ui.theme.DeepBlue

@Composable
fun TopBarArtworksList(
    onClickSearch: () -> Unit,
    gridCellsState: Int,
    onClickChangeGrid: (Int) -> Unit
) {
    TopAppBar(
        backgroundColor = DeepBlue,
        contentColor = Beige,
        elevation = 4.dp,
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Artworks",
                fontSize = 20.sp,
                color = Beige
            )
            Row {
                IconButton(
                    onClick = {
                        onClickSearch()
                    }
                ) {
                    Icon(
                        imageVector = Icons.Rounded.Search,
                        contentDescription = "Search",
                        tint = Beige
                    )
                }
                IconButton(
                    onClick = {
                        onClickChangeGrid(
                            if (gridCellsState == 1) {
                                2
                            } else {
                                1
                            }
                        )
                    }
                ) {
                    Icon(
                        imageVector = Icons.Rounded.GridView,
                        contentDescription = "Reload",
                        tint = Beige
                    )
                }
            }
        }
    }
}