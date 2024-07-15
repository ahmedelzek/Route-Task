package com.example.route.domain.common


sealed class Resource<out T> {

    data class Success<Type>(val data: Type) : Resource<Type>()

    data class Fail(val exception: Throwable) : Resource<Nothing>()

    data object Loading : Resource<Nothing>()
}
