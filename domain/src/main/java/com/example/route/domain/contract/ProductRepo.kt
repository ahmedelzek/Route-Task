package com.example.route.domain.contract

import com.example.route.domain.models.Product

interface ProductRepo {

    suspend fun getALlProduct(): List<Product>
}