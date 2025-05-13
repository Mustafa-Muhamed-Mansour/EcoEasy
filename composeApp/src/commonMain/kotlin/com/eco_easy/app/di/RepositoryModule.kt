package com.eco_easy.app.di

import com.eco_easy.app.repository.CategoryRepository
import com.eco_easy.app.repository.ContentOfCategoryRepository
import com.eco_easy.app.repository.ProductRepository
import org.koin.dsl.module

val repositoryModule = module {
    single { ProductRepository(apiService = get()) }
    single { CategoryRepository(apiService = get()) }
    single { ContentOfCategoryRepository(apiService = get()) }
}