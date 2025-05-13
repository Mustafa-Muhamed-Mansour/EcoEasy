package com.eco_easy.domain.repository

import com.eco_easy.domain.response.ProductResponse

interface ContentOfCategoryRepository {
    suspend fun getContentOfCategory(typeCategory: String): ProductResponse
}