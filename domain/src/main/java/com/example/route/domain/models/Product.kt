package com.example.route.domain.models

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "products")
data class Product(
    val thumbnail: String? = null,
    val rating: Double? = null,
    val description: String? = null,
    @PrimaryKey
    val title: String,
    val discountPercentage: Double? = null,
    val price: Double? = null):Parcelable