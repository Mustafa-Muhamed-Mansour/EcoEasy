package com.eco_easy.app.di

import com.eco_easy.data.repository_impl.CategoryRepositoryImpl
import com.eco_easy.data.repository_impl.ContentOfCategoryRepositoryImpl
import com.eco_easy.data.repository_impl.ProductRepositoryImpl
import com.eco_easy.domain.repository.CategoryRepository
import com.eco_easy.domain.repository.ContentOfCategoryRepository
import com.eco_easy.domain.repository.ProductRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<ProductRepository> { ProductRepositoryImpl(apiService = get()) }
    single<CategoryRepository> { CategoryRepositoryImpl(apiService = get()) }
    single<ContentOfCategoryRepository> { ContentOfCategoryRepositoryImpl(apiService = get()) }
}