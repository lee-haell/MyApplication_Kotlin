/**
 * 앱을 켰을 때 가장 처음 들어 오는 곳
 */
package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        /**
         * 안드로이드에서 bundle이란 map 형태로 구현된 데이터의 묶음이다.
         */
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "user",
                        modifier = Modifier.padding(innerPadding)
                    )
                }

            }
        }
    }
}


//@Composable
//fun Greeting(name: String, modifier: Modifier) {
//    Text(text = "Hello $name!")
//}

@Composable
private fun Greeting(name: String, modifier: Modifier) {
    Surface(color = MaterialTheme.colorScheme.primary) {
        Text (text = "Hello $name!")
    }
}

@Preview(showSystemUi = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        Greeting("Android", androidx.compose.ui.Modifier.Companion.padding(16.dp))
    }
}



