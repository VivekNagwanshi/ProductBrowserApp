package com.example.productbrowserapp.domain.usecase

import com.example.productbrowserapp.domain.model.Product
import com.example.productbrowserapp.domain.repository.ProductRepository

class SearchProductsUseCase(
    private val repository: ProductRepository
) {
    suspend operator fun invoke(query: String): List<Product> {
        return repository.searchProducts(query)
    }
}