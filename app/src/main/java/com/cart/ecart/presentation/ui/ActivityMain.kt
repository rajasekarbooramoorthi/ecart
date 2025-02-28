package com.cart.ecart.presentation.ui

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.cart.ecart.presentation.UserViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ActivityMain : ComponentActivity() {

    private val viewModel: UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.fetchUsers()
        /*      viewModel.users.observe(this) { users ->
                  users.forEach { Log.d("MainActivity", "User: ${it.name}") }
              }*/
        lifecycleScope.launch {
            viewModel.users.collectLatest { users ->
                users.forEach { user ->
                    Log.d("MainActivity", "User: ${user.name}")
                }
            }
        }

    }
}