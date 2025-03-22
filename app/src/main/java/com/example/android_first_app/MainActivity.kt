package com.example.android_first_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.android_first_app.ui.theme.AndroidFirstAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidFirstAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CounterApp(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun CounterApp(modifier: Modifier = Modifier) {
    var count by remember { mutableStateOf(0) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = count.toString(),
            fontSize = 48.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(bottom = 32.dp)
        )

        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.padding(16.dp)
        ) {
            Button(
                onClick = { count-- },
                modifier = Modifier.weight(1f)
            ) {
                Text("Decrement")
            }

            Button(
                onClick = { count++ },
                modifier = Modifier.weight(1f)
            ) {
                Text("Increment")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CounterAppPreview() {
    AndroidFirstAppTheme {
        CounterApp()
    }
}