package com.example.minerva.presentation.views.artworks_list

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.minerva.presentation.views.artworks_list.components.ArtworksColumn
import com.example.minerva.presentation.views.artworks_list.components.TopBarArtworksList
import com.example.minerva.presentation.views.components.BackgroundBox
import com.example.minerva.presentation.views.components.ErrorText
import com.example.minerva.presentation.views.components.ProgressBarMinerva

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ArtworkListScreen(
    viewModel: ArtworkListViewModel = hiltViewModel(),
    navController: NavController
) {
    val state = viewModel.state.value

    val pullRefreshState = rememberPullRefreshState(
        refreshing = state.isRefreshing,
        onRefresh = {
            viewModel.getArtworks()
        }
    )

    var gridCellsState by remember {
        mutableIntStateOf(2)
    }

    Scaffold(
        topBar = {
            TopBarArtworksList(
                viewModel = viewModel,
                gridCellsState = gridCellsState,
                onClickChangeGrid = {
                    gridCellsState = it
                }
            )
        }
    ) { contentPadding ->
        Box(
            modifier = Modifier
                .padding(contentPadding)
                .pullRefresh(pullRefreshState)
        ) {
            BackgroundBox {
                ArtworksColumn(
                    artworks = state.artworks.artworks,
                    gridCellsState = gridCellsState,
                    navController = navController
                )
                if (state.error.isNotBlank()) {
                    ErrorText(
                        errorMessage = state.error
                    )
                }
                if (state.isLoading) {
                    ProgressBarMinerva()
                }
                PullRefreshIndicator(
                    refreshing = state.isRefreshing,
                    state = pullRefreshState,
                    modifier = Modifier.align(Alignment.TopCenter)
                )
            }
        }
    }
}