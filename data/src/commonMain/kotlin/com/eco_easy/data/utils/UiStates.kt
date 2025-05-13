package com.eco_easy.data.utils

import com.eco_easy.domain.response.CategoryResponse
import com.eco_easy.domain.response.ProductResponse

data class UiStateProducts(
    val isLoading: Boolean = false,
    val error: String = "",
    val data: ProductResponse ?= null
)

data class UiStateCategories(
    val isLoading: Boolean = false,
    val error: String = "",
    val data: CategoryResponse ?= null
)