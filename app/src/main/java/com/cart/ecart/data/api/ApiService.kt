package com.cart.ecart.data.api

import com.cart.ecart.domain.model.User
import retrofit2.http.GET

interface ApiService {
    @GET("users")
    suspend fun getUsers(): List<User>
}