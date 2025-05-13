package com.eco_easy.app.compositions.states

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun StateError(
    contentAlignment: Alignment,
    contents: @Composable () -> Unit,
    horizontal: Arrangement.Horizontal,
    vertical: Alignment.Vertical,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier,
        contentAlignment = contentAlignment
    ) {
        Row(
            modifier = modifier,
            horizontalArrangement = horizontal,
            verticalAlignment = vertical
        ) {
            contents()
        }
    }
}