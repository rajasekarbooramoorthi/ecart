package com.cart.ecart

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.cart.ecart.ui.theme.ECartTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import androidx.lifecycle.lifecycleScope
import com.cart.ecart.presentation.UserViewModel
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {
            ECartTheme {
                var text by remember { mutableStateOf("Loading...") }

                // Collect StateFlow updates
                LaunchedEffect(Unit) {
                    lifecycleScope.launch {
                        viewModel.greetingText.collectLatest { newText ->
                            text = newText
                        }
                    }
                }

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        text = text,
                        onButtonClick = { viewModel.updateGreeting("Ra jasekar") },
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(text: String, onButtonClick: () -> Unit, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(text = text)
        Button(onClick = { onButtonClick() }) {
            Text("Update Greeting")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ECartTheme {
        Greeting("Android", {})
    }
}
