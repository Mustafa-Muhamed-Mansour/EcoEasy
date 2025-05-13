package com.eco_easy.app.utils

import com.eco_easy.app.response.CategoryResponse
import com.eco_easy.app.response.ProductResponse


data class UiStateProducts(
    val isLoading: Boolean = false,
    val error: String = "",
    val data: ProductResponse? = null
)

data class UiStateCategories(
    val isLoading: Boolean = false,
    val error: String = "",
    val data: CategoryResponse? = null
)
