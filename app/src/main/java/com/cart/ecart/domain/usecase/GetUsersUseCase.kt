package com.cart.ecart.domain.usecase


import com.cart.ecart.domain.model.Cart
import com.cart.ecart.domain.repository.UserRepository
import com.cart.ecart.domain.sate.ApiState
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetUsersUseCase @Inject constructor(
    private val repository: UserRepository
) {
    fun execute(): Flow<ApiState<List<Cart>>> {

        val response = repository.getUsers()

        return response
    }
}