package com.example.route.data.datasource.offline

import com.example.route.data.api.WebService
import com.example.route.data.contract.ProductOfflineDataSource
import com.example.route.data.database.ProductDAO
import com.example.route.domain.models.Product
import javax.inject.Inject

class ProductOfflineDataSourceImpl@Inject constructor(private val webService: WebService,private val productDao: ProductDAO): ProductOfflineDataSource {


    override suspend fun getAllProduct(): List<Product> {
        return productDao.getAll()
    }
}