package com.cart.ecart.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cart.ecart.domain.model.User
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

    val _users = MutableStateFlow<List<User>>(emptyList())
    val users: StateFlow<List<User>> = _users


    fun fetchUsers() {
        viewModelScope.launch {
            getUsersUseCase.execute().collect { usersList ->
                _users.value = usersList
            }
        }
    }
}