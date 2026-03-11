package com.example.productbrowserapp.data.model

import kotlinx.serialization.Serializable

@Serializable
data class ProductResponse(
    val products: List<ProductDto>
)