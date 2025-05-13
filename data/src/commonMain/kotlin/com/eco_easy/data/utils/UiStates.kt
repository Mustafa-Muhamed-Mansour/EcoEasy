package com.eco_easy.data.utils

import com.eco_easy.domain.response.CategoryResponse
import com.eco_easy.domain.response.ProductResponse


//data class UiStateDragons(
//    val isLoading: Boolean = false,
//    val error: String = "",
//    val data: List<DragonModel>? = null
//)

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


//data class UiStateDragonDetails(
//    val isLoading: Boolean = false,
//    val error: String = "",
//    val data: CharacterResponseById? = null
//)
//
//
//data class UiStateSearchDragons(
//    val isLoading: Boolean = false,
//    val error: String = "",
//    val data: List<SearchDragonsResponseItem>? = null
//)
