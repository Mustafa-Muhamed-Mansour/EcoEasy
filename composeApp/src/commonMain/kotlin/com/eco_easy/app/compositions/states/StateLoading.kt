package com.eco_easy.app.compositions.states

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color


@Composable
fun StateLoading(
    contentAlignment: Alignment,
    modifier: Modifier = Modifier,
    color: Color = Color.Black
) {
    Box(
        modifier = modifier,
        contentAlignment = contentAlignment
    ) {
        CircularProgressIndicator(
            color = color
        )
    }
}