package com.eco_easy.domain.use_cases

import com.eco_easy.domain.repository.ProductRepository
import com.eco_easy.domain.response.ProductResponse

class ProductsUseCase(
    private val productRepository: ProductRepository
) {
    suspend operator fun invoke(): Result<ProductResponse> {
        return try {
            val result = productRepository.getProducts()
            Result.success(value = result)
        } catch (e: Exception) {
            Result.failure(exception = e)
        }
    }
}