package com.example.route.data.repos

import com.example.route.data.contract.ProductOfflineDataSource
import com.example.route.data.contract.ProductOnlineDataSource
import com.example.route.data.datasource.InternetChecker
import com.example.route.domain.common.Resource
import com.example.route.domain.contract.ProductRepo
import com.example.route.domain.models.Product
import javax.inject.Inject

class ProductRepoImpl @Inject constructor(
    private val productOnlineDataSource: ProductOnlineDataSource,
    private val productOfflineDataSource: ProductOfflineDataSource,
    private val internetChecker: InternetChecker
) : ProductRepo {
    override suspend fun getALlProduct(): Resource<List<Product>>{
        return if (internetChecker.isNetworkAvailable()){
            productOnlineDataSource.getAllProduct()
        }else{
            productOfflineDataSource.getAllProduct()
        }
    }
}