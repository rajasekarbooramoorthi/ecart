package com.cart.ecart.domain.usecase


import com.cart.ecart.domain.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetUsersUseCase @Inject constructor(
    private val repository: UserRepository
) {
    fun execute() = repository.getUsers().flowOn(Dispatchers.IO)
}