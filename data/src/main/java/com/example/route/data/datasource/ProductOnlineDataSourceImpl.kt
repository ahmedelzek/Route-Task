package com.example.route.data.datasource

import com.example.route.data.api.WebService
import com.example.route.data.contract.ProductOnlineDataSource
import com.example.route.domain.models.Product
import javax.inject.Inject

class ProductOnlineDataSourceImpl @Inject constructor(
    private val webService: WebService
) : ProductOnlineDataSource {
    override suspend fun getAllProduct(): List<Product> {
        return webService.getAllProducts().products?.filterNotNull()!!.map {
            it.toProduct()
        }
    }
}
