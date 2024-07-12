package com.example.route.data.repos

import com.example.route.data.repos.ProductRepoImpl
import com.example.route.domain.contract.ProductRepo
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class ProductRepositoryModule() {

    @Binds
    abstract fun bindProductRepository(
        productRepositoryImpl: ProductRepoImpl
    ): ProductRepo
}