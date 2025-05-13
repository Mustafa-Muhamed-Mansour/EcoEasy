package com.eco_easy.data.repository_impl

import com.eco_easy.data.datasource.remote.ApiService
import com.eco_easy.domain.repository.ContentOfCategoryRepository
import com.eco_easy.domain.response.ProductResponse

class ContentOfCategoryRepositoryImpl(
    private val apiService: ApiService
): ContentOfCategoryRepository {
    override suspend fun getContentOfCategory(typeCategory: String): ProductResponse {
        return apiService.getContentOfCategory(typeCategory = typeCategory)
    }
}