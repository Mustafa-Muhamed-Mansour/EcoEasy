package com.eco_easy.app.screens.category.categories_self

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import com.eco_easy.app.view_models.CategoriesViewModel
import org.koin.compose.viewmodel.koinViewModel

object CategoriesScreen: Screen {
    @Composable
    override fun Content() {
        val viewModel = koinViewModel<CategoriesViewModel>()
        Categories(viewModel = viewModel)
    }
}