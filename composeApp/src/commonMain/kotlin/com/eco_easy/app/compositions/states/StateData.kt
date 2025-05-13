package com.eco_easy.app.compositions.states

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun StateData(
    contents: @Composable () -> Unit,
    content: @Composable () -> Unit = {},
    modifier: Modifier = Modifier,
    vertical: Arrangement.Vertical = Arrangement.Center,
    horizontal: Alignment.Horizontal = Alignment.CenterHorizontally
) {
    Column(
        modifier = modifier, verticalArrangement = vertical, horizontalAlignment = horizontal
    ) {
        content()
        contents()
    }
}