package com.eco_easy.domain.use_cases

import com.eco_easy.domain.repository.CategoryRepository
import com.eco_easy.domain.response.CategoryResponse

class CategoriesUseCase(
    private val categoryRepository: CategoryRepository
) {
    suspend operator fun invoke(): Result<CategoryResponse> {
        return try {
            val result = categoryRepository.getCategories()
            Result.success(value = result)
        } catch (e: Exception) {
            Result.failure(exception = e)
        }
    }
}