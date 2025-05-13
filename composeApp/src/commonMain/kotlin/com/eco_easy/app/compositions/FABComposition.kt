package com.eco_easy.app.compositions

import androidx.compose.material.FloatingActionButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun FABComposition(
    onClick: () -> Unit,
    content: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    backGroundColor: androidx.compose.ui.graphics.Color = androidx.compose.ui.graphics.Color.White
) {
    FloatingActionButton(
        onClick = onClick,
        content = content,
        modifier = modifier,
        backgroundColor = backGroundColor
    )
}