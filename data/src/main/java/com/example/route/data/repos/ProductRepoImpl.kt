package com.example.route.data.repos

import com.example.route.data.contract.ProductOnlineDataSource
import com.example.route.domain.contract.ProductRepo
import com.example.route.domain.models.Product
import javax.inject.Inject

class ProductRepoImpl @Inject constructor(
    private val productOnlineDataSource: ProductOnlineDataSource
) : ProductRepo {
    override suspend fun getALlProduct(): List<Product> {
        return productOnlineDataSource.getAllProduct()
    }
}