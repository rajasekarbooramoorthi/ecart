package com.cart.ecart.domain.sate

sealed class ApiState<T> {
    data class Success<T>(val data: T) : ApiState<T>()
    data class Error<T>(val message: String) : ApiState<T>()
    class Loading<T> : ApiState<T>()
}