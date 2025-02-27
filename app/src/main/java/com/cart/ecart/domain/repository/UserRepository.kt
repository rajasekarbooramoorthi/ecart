package com.cart.ecart.domain.repository

import com.cart.ecart.domain.model.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    fun getUsers(): Flow<List<User>>
}