package com.codegalaxy.mock21nov.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codegalaxy.mock21nov.ErrorHandler
import com.codegalaxy.mock21nov.NetworkUtils
import com.codegalaxy.mock21nov.NoInternetConnectionException
import com.codegalaxy.mock21nov.UiState
import com.codegalaxy.mock21nov.model.Entity.ProductEntity
import com.codegalaxy.mock21nov.model.dto.ProductData
import com.codegalaxy.mock21nov.model.dto.ProductRequest
import com.codegalaxy.mock21nov.model.repository.IProductRepository
import com.codegalaxy.mock21nov.model.repository.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.CoroutineExceptionHandler

import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(

    private val repository: IProductRepository,

    ) : ViewModel() {

    private val _uiState = MutableLiveData<UiState<String>>()
    val uiState: LiveData<UiState<String>> = _uiState

    private val ceh = CoroutineExceptionHandler { _, throwable ->
        _uiState.postValue(UiState.Error("Failed to submit product ${throwable.localizedMessage}"))
    }

    fun submitProduct(
        name: String,
        year: String,
        price: String,
        cpuModel: String,
        hardDiskSize: String
    ) {
        if (name.isEmpty() || year.isEmpty() || price.isEmpty() || cpuModel.isEmpty() || hardDiskSize.isEmpty()) {
            _uiState.value = UiState.Error("All fields are required")
            return
        }


        viewModelScope.launch(ceh) {

            _uiState.value = UiState.Loading

            val existingProduct = repository.checkProduct(name)

            if (existingProduct != null) {
                _uiState.value = UiState.Error("Data Already exists")
                return@launch
            }

            try {

                //post product to the server
                val productRequest = ProductRequest(
                    name = name,
                    data = ProductData(
                        year.toInt(),
                        price.toDouble(),
                        cpuModel,
                        hardDiskSize
                    )
                )
                val response = repository.postProduct(productRequest)


                //save product in room
                val productEntity = ProductEntity(
                    response.id,
                    response.name,
                    response.data.price,
                    response.data.year,
                    response.data.cpuModel,
                    response.data.hardDiskSize
                )
                repository.saveProduct(productEntity)


                _uiState.value = UiState.Success("Product saved successfully")

            } catch (e: Exception) {


//                _uiState.value = UiState.Error("Failed to save the product ${e.localizedMessage}")
                _uiState.value = UiState.Error(ErrorHandler.getErrorMessage(e))

            }
        }
    }
}
