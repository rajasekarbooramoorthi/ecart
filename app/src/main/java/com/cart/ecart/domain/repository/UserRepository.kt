package com.cart.ecart.domain.repository

import com.cart.ecart.data.api.ApiService
import com.cart.ecart.domain.model.Cart
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import com.cart.ecart.domain.sate.ApiState
import retrofit2.HttpException
import java.io.IOException


class UserRepository @Inject constructor(private val apiService: ApiService) {
    fun getUsers(): Flow<ApiState<List<Cart>>> = flow {
        emit(ApiState.Loading()) // Emit loading state
        try {
            val response = apiService.getUsers()

            emit(ApiState.Success(response)) // Emit success state
        } catch (e: HttpException) { // Handles 404 and other HTTP errors
            val errorMessage = when (e.code()) {
                404 -> "Post not found"
                else -> "Something went wrong (Error ${e.code()})"
            }
            emit(ApiState.Error(errorMessage))
        } catch (e: IOException) { // Handles network issues
            emit(ApiState.Error("Check your internet connection"))
        } catch (e: Exception) { // Handles any other exceptions
            emit(ApiState.Error("Unexpected error: ${e.localizedMessage}"))
        }
    }


}