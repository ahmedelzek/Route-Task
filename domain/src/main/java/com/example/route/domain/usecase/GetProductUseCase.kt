package com.example.route.domain.usecase

import com.example.route.domain.contract.ProductRepo
import com.example.route.domain.models.Product
import javax.inject.Inject

class GetProductUseCase @Inject constructor(
    private val productRepo: ProductRepo
) {
    suspend fun getALlProduct(): List<Product>{
        return productRepo.getALlProduct()
    }
}