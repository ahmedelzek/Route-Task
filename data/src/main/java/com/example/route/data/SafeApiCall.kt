package com.example.route.data

import com.example.route.domain.common.Resource

suspend fun <T> safeApiCall (apiCall: suspend () -> Resource<T>): Resource<T>{
    return try {
        apiCall.invoke()
    } catch (t: Throwable) {
        return Resource.Fail(t)
    }
}