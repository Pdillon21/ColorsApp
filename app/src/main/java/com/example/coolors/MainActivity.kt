package com.example.coolors

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.coolors.ui.elements.BottomBar
import com.example.coolors.ui.theme.CoolorsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CoolorsTheme {
                MainScreen()
            }
        }
    }
}

@SuppressLint("UnrememberedMutableState")
@Composable
fun MainScreen() {
    val currentScreen = mutableStateOf<Screen>(Screen.Home)
    Scaffold(
        bottomBar = {
            CustomBottomNavigation(
                currentScreenId = currentScreen.value.id
            ) {
                currentScreen.value = it
            }
        }
    ) {
        Box(modifier = Modifier.fillMaxSize().padding(0.dp,0.dp,0.dp,it.calculateBottomPadding())){
            HomeScreen()
        }
    }

}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CoolorsTheme {
        MainScreen()
    }
}