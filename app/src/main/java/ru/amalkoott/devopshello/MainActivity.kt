package ru.amalkoott.devopshello

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.amalkoott.devopshello.ui.theme.DevOpsHelloTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DevOpsHelloTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(modifier: Modifier = Modifier) {
    val input = remember { mutableStateOf("") }
    val message = remember { mutableStateOf("") }

    val btnText = if (message.value != "") "CLEAR THE MESSAGE" else "PUSH ME!"
    val action: () -> Unit = { if (message.value != "")
        message.value = ""
    else {
        message.value = "Your input is a text = \"${input.value}\""
        input.value = ""}
    }
    Column(modifier = Modifier
        .padding(horizontal = 16.dp, vertical = 24.dp)
        .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center){
        TextField(
            value = input.value,
            onValueChange = { input.value = it }
        )
        Button(
            onClick = action
        ) {
            Text(
                text = btnText
            )
        }

        Text(
            text = message.value,
            modifier = modifier
        )
    }
}

