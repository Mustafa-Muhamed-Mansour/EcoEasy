package com.eco_easy

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.eco_easy.app.di.initKoin

fun main() {
    initKoin()
    application {
        Window(
            onCloseRequest = ::exitApplication,
            title = "EcoEasy",
        ) {
            App()
        }
    }
}