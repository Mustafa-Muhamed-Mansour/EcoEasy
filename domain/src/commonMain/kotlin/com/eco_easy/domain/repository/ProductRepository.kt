package com.eco_easy.domain.repository

import com.eco_easy.domain.response.ProductResponse

interface ProductRepository {
    suspend fun getProducts(): ProductResponse
}