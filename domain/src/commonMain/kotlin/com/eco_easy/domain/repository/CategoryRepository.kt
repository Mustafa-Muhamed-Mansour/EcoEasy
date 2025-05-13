package com.eco_easy.domain.repository

import com.eco_easy.domain.response.CategoryResponse

interface CategoryRepository {
    suspend fun getCategories(): CategoryResponse
}