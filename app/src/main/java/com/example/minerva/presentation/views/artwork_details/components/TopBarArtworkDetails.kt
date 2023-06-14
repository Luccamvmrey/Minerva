package com.example.minerva.presentation.views.artwork_details.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.minerva.presentation.navigation.Screen
import com.example.minerva.presentation.ui.theme.Beige
import com.example.minerva.presentation.ui.theme.DeepBlue

@Composable
fun TopBarArtworkDetails(
    navController: NavController
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
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(
                onClick = {
                    navController.navigate(
                        Screen.ArtworkListScreen.route
                    ) {
                        popUpTo(Screen.ArtworkDetailScreen.route) {
                            inclusive = true
                        }
                    }
                }
            ) {
                Icon(
                    imageVector = Icons.Rounded.ArrowBack,
                    contentDescription = "Search",
                    tint = Beige
                )
            }
        }
    }
}