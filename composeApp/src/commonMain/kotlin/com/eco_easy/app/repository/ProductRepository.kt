package com.eco_easy.app.repository

import com.eco_easy.app.network.remote.ApiService
import com.eco_easy.app.response.ProductResponse


class ProductRepository(
    private val apiService: ApiService
) {
    private suspend fun getProducts(): ProductResponse {
        return apiService.getProducts()
    }
    suspend fun fetchAllProducts(): Result<ProductResponse> {
        val result = this.getProducts()
        return try {
            Result.success(value = result)
        } catch (e: Exception) {
            Result.failure(exception = e)
        }
    }
}