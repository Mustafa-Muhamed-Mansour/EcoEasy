package com.eco_easy.app.di

import com.eco_easy.domain.use_cases.CategoriesUseCase
import com.eco_easy.domain.use_cases.ContentOfCategoryUseCase
import com.eco_easy.domain.use_cases.ProductsUseCase
import org.koin.dsl.module

val useCaseModule = module {
    single { ProductsUseCase(productRepository = get()) }
    single { CategoriesUseCase(categoryRepository = get()) }
    single { ContentOfCategoryUseCase(contentOfCategoryRepository = get()) }
}