package com.straccion.ecommerce.domains.util

sealed class Response<out T> {
    data object Loading: Response<Nothing>()
    data class Success<out T>(val data: T): Response<T>()
    data class Failure<out T>(val message: String): Response<T>()
}
