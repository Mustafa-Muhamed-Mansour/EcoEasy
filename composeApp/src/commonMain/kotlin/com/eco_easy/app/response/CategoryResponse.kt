package com.eco_easy.app.response

import kotlinx.serialization.Serializable

@Serializable
data class CategoryResponse(
    val categories: List<String>,
    val status: String
)