package com.eco_easy.app.screens.category.content_of_categories

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import com.eco_easy.app.view_models.ContentOfCategoryViewModel
import org.koin.compose.viewmodel.koinViewModel

class ContentOfCategoriesScreen(
    private val category: String
) : Screen {
    @Composable
    override fun Content() {
        val viewModel = koinViewModel<ContentOfCategoryViewModel>()
        ContentOfCategories(
            category = category,
            viewModel = viewModel
        )
    }
}