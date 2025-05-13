package com.eco_easy.domain.entity

import kotlinx.serialization.Serializable

@Serializable
data class ProductModel(
    val description: String,
    val image: String,
    val price: Int,
    val title: String
)