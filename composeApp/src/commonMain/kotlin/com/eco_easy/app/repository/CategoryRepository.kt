package com.eco_easy.app.repository

import com.eco_easy.app.network.remote.ApiService
import com.eco_easy.app.response.CategoryResponse


class CategoryRepository(
    private val apiService: ApiService
) {
    private suspend fun getCategories(): CategoryResponse {
        return apiService.getCategories()
    }
    suspend fun fetchAllCategories(): Result<CategoryResponse> {
        val result = this.getCategories()
        return try {
            Result.success(value = result)
        } catch (e: Exception) {
            Result.failure(exception = e)
        }
    }
}