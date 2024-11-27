package com.codegalaxy.mock21nov.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codegalaxy.mock21nov.ErrorHandler
import com.codegalaxy.mock21nov.NoInternetConnectionException
import com.codegalaxy.mock21nov.UiState
import com.codegalaxy.mock21nov.model.dto.ProductResponse
import com.codegalaxy.mock21nov.model.repository.IProductRepository
import com.codegalaxy.mock21nov.model.repository.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class FetchViewModel @Inject constructor(

    private val repository: IProductRepository

) : ViewModel() {

    private val _uiState = MutableLiveData<UiState<List<ProductResponse>>>()
    val uiState: LiveData<UiState<List<ProductResponse>>> = _uiState

    fun fetchProducts(ids: List<String>) {
        viewModelScope.launch {

            _uiState.value = UiState.Loading

            try {

                val products = repository.fetchProductsByIds(ids)

                _uiState.value = UiState.Success(products)

            } catch (e: Exception) {

//                _uiState.value = UiState.Error("Failed to fetch products: ${e.message}")
                _uiState.value = UiState.Error(ErrorHandler.getErrorMessage(e))

            }
        }
    }
}