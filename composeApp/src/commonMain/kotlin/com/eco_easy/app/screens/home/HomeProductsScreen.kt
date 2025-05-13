package com.eco_easy.app.screens.home

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import com.eco_easy.app.view_models.ProductsViewModel
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.annotation.KoinExperimentalAPI

object HomeProductsScreen : Screen {
    @OptIn(KoinExperimentalAPI::class)
    @Composable
    override fun Content() {
        val viewModel = koinViewModel<ProductsViewModel>()
        HomeProducts(viewModel = viewModel)
    }
}
