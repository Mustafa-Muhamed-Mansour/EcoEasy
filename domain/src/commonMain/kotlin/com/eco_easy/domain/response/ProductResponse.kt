package com.eco_easy.domain.response

import com.eco_easy.domain.entity.ProductModel
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProductResponse(
    @SerialName("products")
    val productModels: List<ProductModel>,
    val status: String
)