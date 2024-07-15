package com.example.route.data.datasource.online

import com.example.route.data.api.WebService
import com.example.route.data.contract.ProductOnlineDataSource
import com.example.route.data.database.ProductDAO
import com.example.route.data.safeApiCall
import com.example.route.domain.common.Resource
import com.example.route.domain.models.Product
import javax.inject.Inject

class ProductOnlineDataSourceImpl @Inject constructor(
    private val webService: WebService,
    private val productDao: ProductDAO
) : ProductOnlineDataSource {

    override suspend fun insertAllProducts() {
        val data = webService.getAllProducts().products?.filterNotNull()!!.map {
            it.toProduct()
        }
        productDao.insertAll(data)
    }
    override suspend fun getAllProduct(): Resource<List<Product>> {
        val productList = webService.getAllProducts().products?.filterNotNull()!!.map {
            it.toProduct()
        }
        return safeApiCall {
            Resource.Success(productList)
        }
    }
}
