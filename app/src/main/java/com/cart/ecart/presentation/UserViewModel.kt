package com.cart.ecart.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cart.ecart.domain.model.Cart
import com.cart.ecart.domain.sate.ApiState
import com.cart.ecart.domain.usecase.GetUsersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

import javax.inject.Inject


@HiltViewModel
class UserViewModel @Inject constructor(
    private val getUsersUseCase: GetUsersUseCase
) : ViewModel() {

    val _users = MutableStateFlow<List<Cart>>(emptyList())
    val users: StateFlow<List<Cart>> = _users

    private val _greetingText = MutableStateFlow("Hello, Android!") // Initial value
    val greetingText: StateFlow<String> = _greetingText

    fun updateGreeting(name: String) {
        viewModelScope.launch {
            _greetingText.value = "Hello, $name!" // Update StateFlow
            fetchUsers()
        }
    }

    fun fetchUsers() {
        viewModelScope.launch {
            getUsersUseCase.execute().collect { response ->
                when (response) {
                    is ApiState.Loading -> {
                        println("Rajasekar Loading.....")
                    }

                    is ApiState.Success -> {
                        _users.value = response.data
                        println("Rajasekar Success.....")
                    }

                    is ApiState.Error -> {
                        println("Rajasekar Error.....")
                    }
                }
            }
        }
    }
}