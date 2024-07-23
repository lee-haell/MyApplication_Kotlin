/**
 * 앱을 켰을 때 가장 처음 들어 오는 곳
 */
package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.size
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
                MyApp(modifier = Modifier.fillMaxSize())
            }
        }
    }
}

/**
 * 재사용 가능한 MyApp 함수 생성
 */
@Composable
fun MyApp(
    modifier: Modifier = Modifier,
    names: List<String> = listOf("World", "Compose")
) {
    Column(modifier = modifier.padding(0.dp, 5.dp, 0.dp, 0.dp)) {
        for (name in names) {
            Greeting(name = name)
        }
    }
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    /**
     * private 키워드는 접근 범위를 제한
     * Greeting 함수는 동일한 파일 내에 다른 코드에서 호출될 수 있음
     * 하지만 다른 파일에서 호출될 수 없음
     */
    Surface(
        color = MaterialTheme.colorScheme.primary,
        modifier = modifier.padding(10.dp, 5.dp, 10.dp, 5.dp) //감싸는 요소에 대한 padding
    ) {
        Column(
            modifier = modifier
                .fillMaxWidth() //최대 가로 크기
        ) {
        Column(modifier = modifier.padding(24.dp)){ //text 영역에 대한 padding
            Text("Hello,")
            Text("$name!")
        }
        }
    }
}

/**
 * 미리보기
 */
@Preview(showSystemUi = true, showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        MyApp()
    }
}