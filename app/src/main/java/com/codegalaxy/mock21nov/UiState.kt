package com.codegalaxy.mock21nov

import com.codegalaxy.mock21nov.model.dto.ProductResponse

sealed class UiState<out T> {

    data object Loading : UiState<Nothing>()
    data class Success<T>(val data: T) : UiState<T>()
    data class Error(val message: String) : UiState<Nothing>()
}