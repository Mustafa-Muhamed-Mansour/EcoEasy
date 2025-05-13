package com.eco_easy.app.repository

import com.eco_easy.app.network.remote.ApiService
import com.eco_easy.app.response.ProductResponse


class ContentOfCategoryRepository(
    private val apiService: ApiService
) {
    private suspend fun getContentOfCategory(typeCategory: String): ProductResponse {
        return apiService.getContentOfCategory(typeCategory = typeCategory)
    }
    suspend fun fetchAllContentOfCategory(typeCategory: String): Result<ProductResponse> {
        val result = this.getContentOfCategory(typeCategory = typeCategory)
        return try {
            Result.success(value = result)
        } catch (e: Exception) {
            Result.failure(exception = e)
        }
    }
}