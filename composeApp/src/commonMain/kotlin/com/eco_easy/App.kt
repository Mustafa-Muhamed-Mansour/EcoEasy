package com.eco_easy

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import com.eco_easy.app.screens.home.HomeProductsScreen
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    Navigator(screen = HomeProductsScreen)

}