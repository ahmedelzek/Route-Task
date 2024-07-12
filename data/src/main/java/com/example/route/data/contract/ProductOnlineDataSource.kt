package com.example.route.data.contract

import com.example.route.domain.models.Product


interface ProductOnlineDataSource {
    suspend fun getAllProduct(): List<Product>
}