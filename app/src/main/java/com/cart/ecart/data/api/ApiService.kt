package com.cart.ecart.data.api

import com.cart.ecart.domain.model.Cart
import retrofit2.http.GET

interface ApiService {
    @GET("cart")
    suspend fun getUsers(): List<Cart>
}