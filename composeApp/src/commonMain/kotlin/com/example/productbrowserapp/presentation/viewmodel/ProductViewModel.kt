package com.example.productbrowserapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.productbrowserapp.domain.model.Product
import com.example.productbrowserapp.domain.usecase.GetProductsUseCase
import com.example.productbrowserapp.domain.usecase.SearchProductsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ProductViewModel(
    private val getProductsUseCase: GetProductsUseCase,
    private val searchProductsUseCase: SearchProductsUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow<List<Product>>(emptyList())
    val uiState = _uiState.asStateFlow()
    init {
        loadProducts()
    }
    fun loadProducts() {
        viewModelScope.launch {
            _uiState.value = getProductsUseCase()
        }
    }

    fun search(query: String) {
        viewModelScope.launch {
            _uiState.value = searchProductsUseCase(query)
        }
    }
}