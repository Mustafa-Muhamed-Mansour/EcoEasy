package com.eco_easy.data.repository_impl

import com.eco_easy.data.datasource.remote.ApiService
import com.eco_easy.domain.repository.CategoryRepository
import com.eco_easy.domain.response.CategoryResponse

class CategoryRepositoryImpl(
    private val apiService: ApiService
): CategoryRepository {
    override suspend fun getCategories(): CategoryResponse {
        return apiService.getCategories()
    }
}