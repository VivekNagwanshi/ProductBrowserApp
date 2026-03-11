package com.example.productbrowserapp.data.repository

import com.example.productbrowserapp.data.model.ProductDto
import com.example.productbrowserapp.data.remote.ProductApi
import com.example.productbrowserapp.domain.model.Product
import com.example.productbrowserapp.domain.repository.ProductRepository

class ProductRepositoryImpl(
    private val api: ProductApi
) : ProductRepository {

    override suspend fun getProducts(): List<Product> {
        return api.getProducts().map { it.toDomain() }
    }

    override suspend fun searchProducts(query: String): List<Product> {
        return api.searchProducts(query).map { it.toDomain() }
    }

    override suspend fun getProductDetail(id: Int): Product {
        return api.getProductDetail(id).toDomain()
    }

    fun ProductDto.toDomain() = Product(
        id,
        title,
        description,
        price,
        brand,
        rating,
        thumbnail,
        images
    )
}