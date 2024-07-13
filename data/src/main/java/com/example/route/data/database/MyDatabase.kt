package com.example.route.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.route.domain.models.Product

@Database(entities = [Product::class], version = 1)
abstract class MyDatabase: RoomDatabase() {
    abstract fun productDao(): ProductDAO
}