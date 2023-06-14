package com.example.minerva.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.minerva.presentation.views.artworks_list.ArtworkListScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.ArtworkListScreen.route) {
        composable(route = Screen.ArtworkListScreen.route) {
            ArtworkListScreen(navController = navController)
        }
    }
}