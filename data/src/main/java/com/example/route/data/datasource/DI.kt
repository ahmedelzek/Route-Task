package com.example.route.data.datasource


import com.example.route.data.contract.ProductOnlineDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class ProductOnlineDataSourceModule() {

    @Binds
    abstract fun bindProductOnlineDataSource(
        productOnlineDataSourceImpl: ProductOnlineDataSourceImpl
    ): ProductOnlineDataSource
}