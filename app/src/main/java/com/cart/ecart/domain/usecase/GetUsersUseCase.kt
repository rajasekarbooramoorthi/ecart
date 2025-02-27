package com.cart.ecart.domain.usecase


import com.cart.ecart.domain.model.User
import com.cart.ecart.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetUsersUseCase @Inject constructor(
    private val repository: UserRepository
) {
    fun execute(): Flow<List<User>> = repository.getUsers()
}