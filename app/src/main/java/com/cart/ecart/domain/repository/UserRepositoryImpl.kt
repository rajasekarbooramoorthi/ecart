package com.cart.ecart.domain.repository

import com.cart.ecart.data.api.ApiService
import com.cart.ecart.domain.model.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : UserRepository {

    override fun getUsers(): Flow<List<User>> = flow {
        emit(apiService.getUsers())
    }
}