package com.eco_easy.app.di

import com.eco_easy.app.view_models.CategoriesViewModel
import com.eco_easy.app.view_models.ContentOfCategoryViewModel
import com.eco_easy.app.view_models.ProductsViewModel
import org.koin.compose.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { ProductsViewModel(productsUseCase = get()) }
    viewModel { CategoriesViewModel(categoriesUseCase = get()) }
    viewModel { ContentOfCategoryViewModel(contentOfCategoryUseCase = get()) }
}