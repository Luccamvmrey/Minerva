package com.example.minerva.presentation.views.artworks_list.components

import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.minerva.presentation.ui.theme.Beige
import com.example.minerva.presentation.ui.theme.DeepBlue

@Composable
fun SearchBarMinerva(
    query: String,
    widthScale: Float,
    onValueChange: (String) -> Unit,
    onFocusChange: (Boolean) -> Unit,
    trailingIcon: @Composable () -> Unit,
) {

    val colors = TextFieldDefaults.textFieldColors(
        backgroundColor = Beige,
        cursorColor = DeepBlue,
        textColor = DeepBlue,
        focusedLabelColor = Color.Transparent,
        unfocusedLabelColor = Color.Transparent,
        focusedIndicatorColor = Color.Transparent,
        unfocusedIndicatorColor = Color.Transparent
    )

    TextField(
        value = query,
        onValueChange = {
            onValueChange(query)
        },
        trailingIcon = {
            trailingIcon()
        },
        shape = RoundedCornerShape(16.dp),
        colors = colors,
        modifier = Modifier
            .fillMaxWidth(0.9f * widthScale)
            .fillMaxHeight(0.7f)

            .focusable(true)
            .onFocusChanged {
                onFocusChange(
                    it.isFocused
                )
            }
    )
}