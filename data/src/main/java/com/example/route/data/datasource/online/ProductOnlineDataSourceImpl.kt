package com.example.route.data.datasource.online

import com.example.route.data.api.WebService
import com.example.route.data.contract.ProductOnlineDataSource
import com.example.route.data.safeApiCall
import com.example.route.domain.common.Resource
import com.example.route.domain.models.Product
import javax.inject.Inject

class ProductOnlineDataSourceImpl @Inject constructor(
    private val webService: WebService,
) : ProductOnlineDataSource {
    override suspend fun getAllProduct(): Resource<List<Product>> {

        return safeApiCall {
            Resource.Success(webService.getAllProducts().products!!.filterNotNull().map {
                it.toProduct()
            })
        }
    }
}
