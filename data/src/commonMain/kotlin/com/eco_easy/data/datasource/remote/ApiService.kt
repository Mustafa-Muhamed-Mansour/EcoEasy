package com.eco_easy.data.datasource.remote

import com.eco_easy.data.utils.Constants.BASE_URL
import com.eco_easy.data.utils.Constants.CATEGORY
import com.eco_easy.data.utils.Constants.LIMIT
import com.eco_easy.data.utils.Constants.PRODUCTS
import com.eco_easy.domain.response.CategoryResponse
import com.eco_easy.domain.response.ProductResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.request.url

class ApiService(
    private val client: HttpClient
) {
    suspend fun getProducts(): ProductResponse {
        return client.get {
            url(urlString = "$BASE_URL/$PRODUCTS?")
            parameter(key = "limit", value = LIMIT)
        }.body<ProductResponse>()
    }

    suspend fun getCategories(): CategoryResponse {
        return client.get {
            url(urlString = "$BASE_URL/$CATEGORY?")
        }.body<CategoryResponse>()
    }

    suspend fun getContentOfCategory(typeCategory: String): ProductResponse {
        return client.get {
            url(urlString = "$BASE_URL/$CATEGORY?")
            parameter(key = "type", value = typeCategory)
        }.body<ProductResponse>()
    }
}