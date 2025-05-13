package com.eco_easy.app.view_models

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eco_easy.data.utils.UiStateCategories
import com.eco_easy.data.utils.UiStateProducts
import com.eco_easy.domain.use_cases.CategoriesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent

class CategoriesViewModel(
    private val categoriesUseCase: CategoriesUseCase
): ViewModel(), KoinComponent {
    private val _uiState = MutableStateFlow(value = UiStateCategories())
    val uiState = _uiState.asStateFlow()

    init {
        fetchAllCategories()
    }

    private fun fetchAllCategories() = viewModelScope.launch {
        _uiState.update { UiStateCategories(isLoading = true) }
        val response = categoriesUseCase()
        response.fold(
            onSuccess = { data ->
                _uiState.update { UiStateCategories(data = data) }
            },
            onFailure = { failure ->
                _uiState.update { UiStateCategories(error = failure?.message.toString()) }
            }
        )
    }
}