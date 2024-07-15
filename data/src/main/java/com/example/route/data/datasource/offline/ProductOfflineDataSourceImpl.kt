package com.example.route.data.datasource.offline

import com.example.route.data.api.WebService
import com.example.route.data.contract.ProductOfflineDataSource
import com.example.route.data.database.ProductDAO
import com.example.route.data.safeApiCall
import com.example.route.domain.common.Resource
import com.example.route.domain.models.Product
import javax.inject.Inject

class ProductOfflineDataSourceImpl@Inject constructor(private val productDao: ProductDAO): ProductOfflineDataSource {


    override suspend fun getAllProduct(): Resource<List<Product>> {
        val productList = productDao.getAll()
        return safeApiCall {
            Resource.Success(productList)
        }
    }
}