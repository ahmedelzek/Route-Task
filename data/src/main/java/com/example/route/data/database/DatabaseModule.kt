package com.example.route.data.database

import android.app.Application
import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    @Singleton
    fun provideContext(app: Application): Context = app.applicationContext

    @Provides
    @Singleton
    fun provideDatabase(context: Context): MyDatabase =
        Room.databaseBuilder(context , MyDatabase::class.java, "database").build()

    @Provides
    fun provideProductDao(database: MyDatabase): ProductDAO = database.productDao()
}