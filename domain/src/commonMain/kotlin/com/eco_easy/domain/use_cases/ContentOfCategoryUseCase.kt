package com.eco_easy.domain.use_cases

import com.eco_easy.domain.repository.ContentOfCategoryRepository
import com.eco_easy.domain.response.ProductResponse

class ContentOfCategoryUseCase(
    private val contentOfCategoryRepository: ContentOfCategoryRepository
) {
    suspend operator fun invoke(typeCategory: String): Result<ProductResponse> {
        return try {
            val result = contentOfCategoryRepository.getContentOfCategory(typeCategory = typeCategory)
            Result.success(value = result)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}