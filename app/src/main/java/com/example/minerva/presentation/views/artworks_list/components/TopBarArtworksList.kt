package com.example.minerva.presentation.views.artworks_list.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.GridView
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.minerva.presentation.ui.theme.Beige
import com.example.minerva.presentation.ui.theme.DeepBlue
import com.example.minerva.presentation.views.artworks_list.ArtworkListViewModel

@Composable
fun TopBarArtworksList(
    viewModel: ArtworkListViewModel,
    gridCellsState: Int,
    onClickChangeGrid: (Int) -> Unit
) {
    var query by remember {
        mutableStateOf("")
    }

    var searchBarOpen by remember {
        mutableStateOf(false)
    }

    val searchBarWidth by animateFloatAsState(
        targetValue = if (searchBarOpen) 1f else 0f,
        animationSpec = tween(500)
    )

    val focusRequester = remember {
        FocusRequester()
    }

    val colors = TextFieldDefaults.textFieldColors(
        backgroundColor = Beige,
        cursorColor = DeepBlue,
        textColor = DeepBlue,
        focusedLabelColor = Color.Transparent,
        unfocusedLabelColor = Color.Transparent,
        focusedIndicatorColor = Color.Transparent,
        unfocusedIndicatorColor = Color.Transparent
    )

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
            if (!searchBarOpen) {
                Text(
                    text = "Artworks",
                    fontSize = 20.sp,
                    color = Beige
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                TextField(
                    value = query,
                    onValueChange = { query = it },
                    shape = RoundedCornerShape(16.dp),
                    colors = colors,
                    modifier = Modifier
                        .fillMaxWidth(0.9f * searchBarWidth)
                        .fillMaxHeight(0.9f)
                        .focusRequester(focusRequester),
                    trailingIcon = {
                        IconButton(
                            onClick = {
                                if (query.isNotBlank()) {
                                    viewModel.searchArtworks(query)
                                }
                            }
                        ) {
                            Icon(
                                imageVector = Icons.Rounded.Search,
                                contentDescription = "Search",
                                tint = DeepBlue
                            )
                        }
                    }
                )
                if (!searchBarOpen) {
                    IconButton(
                        onClick = {
                            searchBarOpen = true
                            focusRequester.requestFocus()
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Rounded.Search,
                            contentDescription = "Search",
                            tint = Beige
                        )
                    }
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