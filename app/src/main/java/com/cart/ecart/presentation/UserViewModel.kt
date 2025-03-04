package com.cart.ecart.presentation

import androidx.lifecycle.ViewModel
import com.cart.ecart.domain.model.Cart
import com.cart.ecart.domain.sate.ApiState.Error
import com.cart.ecart.domain.sate.ApiState.Loading
import com.cart.ecart.domain.sate.ApiState.Success
import com.cart.ecart.domain.usecase.GetUsersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val getUsersUseCase: GetUsersUseCase
) : ViewModel() {
    private val job = SupervisorJob() // Allows child coroutines to fail independently
    private val coroutineContext = Dispatchers.IO + job
    private val coroutineScope = CoroutineScope(coroutineContext)

    val _users = MutableStateFlow<List<Cart>>(emptyList())
    val users: StateFlow<List<Cart>> = _users

    private val _greetingText = MutableStateFlow("Hello, Android!") // Initial value
    val greetingText: StateFlow<String> = _greetingText

    fun updateGreeting(name: String) {
        coroutineScope.launch {
            _greetingText.value = "Hello, $name!" // Update StateFlow
            fetchUsers()
        }
    }

    fun fetchUsers() {
        coroutineScope.launch {
            getUsersUseCase.execute().collect { response ->
                when (response) {
                    is Loading -> {
                        println("Rajasekar Loading.....")
                    }

                    is Success -> {
                        _users.value = response.data
                        println("Rajasekar Success.....{${response.data.first().createdAt}}")
                    }

                    is Error -> {
                        println("Rajasekar Error.....")
                    }
                }
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        job.cancel() // Cancel all coroutines when ViewModel is cleared
    }
}