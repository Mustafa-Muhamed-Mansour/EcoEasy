package com.eco_easy.data.repository_impl

import com.eco_easy.data.datasource.remote.ApiService
import com.eco_easy.domain.repository.ProductRepository
import com.eco_easy.domain.response.ProductResponse

class ProductRepositoryImpl(
    private val apiService: ApiService
): ProductRepository {
    override suspend fun getProducts(): ProductResponse {
        return apiService.getProducts()
    }
}