package com.example.route.data.contract

import com.example.route.domain.common.Resource
import com.example.route.domain.models.Product


interface ProductOnlineDataSource {
    suspend fun getAllProduct(): Resource<List<Product>>
}