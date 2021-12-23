package com.example.coolors.ui.elements

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.coolors.ui.theme.CoolorsTheme

@Composable
fun BottomBar(modifier: Modifier) {
    Card(modifier = Modifier.fillMaxWidth(), RoundedCornerShape(8.dp)) {
        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceEvenly) {
            Text(text = "Hola Mundo")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CoolorsTheme {

    }
}