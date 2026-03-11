package com.example.productbrowserapp.data.remote

import com.example.productbrowserapp.data.model.ProductDto

interface ProductApi {

    suspend fun getProducts(): List<ProductDto>

    suspend fun searchProducts(query: String): List<ProductDto>

    suspend fun getProductDetail(id: Int): ProductDto
}