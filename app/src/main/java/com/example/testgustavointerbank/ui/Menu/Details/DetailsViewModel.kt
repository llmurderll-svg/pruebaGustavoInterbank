package com.example.testgustavointerbank.ui.Menu.Details


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.Entity.ProductEntity
import com.example.domain.UseCases.GetProductsUseCase
import com.example.domain.UseCases.GetUploadProductsUseCase
import com.example.testgustavointerbank.models.ProductModel
import com.example.testgustavointerbank.models.toModel
import kotlinx.coroutines.launch

class DetailsViewModel(private val getProductsUseCase: GetProductsUseCase, private val getUploadProductsUseCase: GetUploadProductsUseCase) :ViewModel(){
    private val _products = MutableLiveData<List<ProductModel>>()
    val products : LiveData<List<ProductModel>> = _products

    init {
        getProducts()
    }

    fun getProducts(){
        viewModelScope.launch {
            getProductsUseCase().also { productsEntity ->
                _products.value = productsEntity.map { it.toModel() }
            }
        }
    }

    fun getUploadProducts(){
        viewModelScope.launch {
            getUploadProductsUseCase().also { productsEntity ->
                _products.value = productsEntity.map { it.toModel() }
            }
        }
    }
}