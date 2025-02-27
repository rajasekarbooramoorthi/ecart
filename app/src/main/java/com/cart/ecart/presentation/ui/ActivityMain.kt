package com.cart.ecart.presentation.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import com.cart.ecart.presentation.UserViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ActivityMain : ComponentActivity() {

    private val viewModel: UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.fetchUsers()
        /*      viewModel.users.observe(this) { users ->
                  users.forEach { Log.d("MainActivity", "User: ${it.name}") }
              }*/
    }
}