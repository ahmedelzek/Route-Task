package com.example.route.data.datasource.offline


import com.example.route.data.contract.ProductOfflineDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class ProductOfflineDataSourceModule() {

    @Binds
    abstract fun bindProductOfflineDataSource(
        productOfflineDataSourceImpl: ProductOfflineDataSourceImpl
    ): ProductOfflineDataSource
}