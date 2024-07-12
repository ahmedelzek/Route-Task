package com.example.route.data.api

import com.example.route.data.models.ProductResponse
import retrofit2.http.GET

interface WebService {

    @GET("/products")
    suspend fun getAllProducts(): ProductResponse
}