/**
 * 앱을 켰을 때 가장 처음 들어 오는 곳
 */
package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialogDefaults.shape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DividerDefaults.color
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme
import androidx.compose.ui.graphics.Color


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                MyApp()
            }
        }
    }

}


@Composable
fun MyApp(
    modifier: Modifier = Modifier,
    names: List<String> = listOf("First Memo", "Second Memo")
) {
    Column(modifier = modifier.padding(vertical = 4.dp)) {
        for (name in names) {
            Greeting(name = name)
        }
    }
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    /**
     * 리멤버 함수는 컴포즈에서 상태 보존, 컴포즈가 추적할 때마다 해당 상태를 사용할 수 있음
     * 이를 리컴포지션이라고 한다.
     */
    val expanded = remember {mutableStateOf(false)}
    val buttonPadding = if (expanded.value) 48.dp else 0.dp
    Surface(
        color = MaterialTheme.colorScheme.primary,
        modifier = modifier.padding(vertical = 4.dp, horizontal = 8.dp)
    )
    {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.padding(24.dp)
        )
        {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(bottom = buttonPadding)
            ) {
                Text("Hello,")
                Text("$name!")
            }
                ElevatedButton(
                    onClick = {expanded.value = !expanded.value}, //버튼을 클릭할 때 상태 반전
                ) {
                    Text(if (expanded.value) "Show less" else "Show more")
                }
        }
    }
}


@Preview(showSystemUi = true, showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        MyApp()
    }
}

