package com.example.route.data.contract

import com.example.route.domain.models.Product

interface ProductOfflineDataSource {

    suspend fun getAllProduct(): List<Product>
}