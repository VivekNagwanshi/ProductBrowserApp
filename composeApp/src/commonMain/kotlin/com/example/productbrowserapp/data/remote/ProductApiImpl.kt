package com.example.productbrowserapp.data.remote

import com.example.productbrowserapp.data.model.ProductDto
import com.example.productbrowserapp.data.model.ProductResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class ProductApiImpl(
    private val client: HttpClient
) : ProductApi {

    override suspend fun getProducts(): List<ProductDto> {
        val response: ProductResponse =
            client.get("https://dummyjson.com/products").body()
        return response.products
    }

    override suspend fun searchProducts(query: String): List<ProductDto> {
        val response: ProductResponse =
            client.get("https://dummyjson.com/products/search?q=$query").body()
        return response.products
    }

    override suspend fun getProductDetail(id: Int): ProductDto {
        return client.get("https://dummyjson.com/products/$id").body()
    }
}