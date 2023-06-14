package com.example.minerva.presentation.navigation

sealed class Screen(val route: String) {
    object ArtworkListScreen : Screen("artwork_list_screen")
    object ArtworkDetailScreen : Screen("artwork_detail_screen")
}
