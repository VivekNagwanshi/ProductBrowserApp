package com.example.productbrowserapp.domain.repository

import com.example.productbrowserapp.domain.model.Product

class FakeProductRepository : ProductRepository {

    override suspend fun getProducts(): List<Product> {
        return listOf(
            Product(
                id = 1,
                title = "Test Product",
                description = "Test Description",
                brand = "Test Brand",
                price = 100.0,
                rating = 4.5,
                thumbnail = "",
                images = emptyList()
            )
        )
    }

    override suspend fun searchProducts(query: String): List<Product> {
        return listOf(
            Product(
                id = 2,
                title = "Search Product",
                description = "Search Description",
                brand = "Test Brand",
                price = 200.0,
                rating = 4.0,
                thumbnail = "",
                images = emptyList()
            )
        )
    }

    override suspend fun getProductDetail(id: Int): Product {
        TODO("Not yet implemented")
    }
}