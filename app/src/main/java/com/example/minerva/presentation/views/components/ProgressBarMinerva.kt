package com.example.minerva.presentation.views.components

import androidx.compose.animation.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.minerva.presentation.ui.theme.Cerise
import com.example.minerva.presentation.ui.theme.MediumSlateBlue
import com.example.minerva.presentation.ui.theme.NaplesYellow

@Composable
fun ProgressBarMinerva() {
    val color = remember {
        Animatable(NaplesYellow)
    }

    LaunchedEffect(Unit) {
        color.animateTo(Cerise, animationSpec = tween(500))
        color.animateTo(MediumSlateBlue, animationSpec = tween(500))
        color.animateTo(NaplesYellow, animationSpec = tween(500))
        color.animateTo(Cerise, animationSpec = tween(500))
        color.animateTo(MediumSlateBlue, animationSpec = tween(500))
        color.animateTo(NaplesYellow, animationSpec = tween(500))
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator(
            color = color.value
        )
    }
}

