package com.eco_easy.app.view_models

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eco_easy.data.utils.UiStateProducts
import com.eco_easy.domain.use_cases.ContentOfCategoryUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent

class ContentOfCategoryViewModel(
    private val contentOfCategoryUseCase: ContentOfCategoryUseCase
) : ViewModel(), KoinComponent {
    private val _uiState = MutableStateFlow(value = UiStateProducts())
    val uiState = _uiState.asStateFlow()

    fun fetchContentOfCategory(typeCategory: String) = viewModelScope.launch {
        _uiState.update { UiStateProducts(isLoading = true) }
        val response = contentOfCategoryUseCase(typeCategory = typeCategory)
        response.fold(
            onSuccess = { data ->
                _uiState.update { UiStateProducts(data = data) }
            },
            onFailure = { failure ->
                _uiState.update { UiStateProducts(error = failure?.message.toString()) }
            }
        )
    }
}