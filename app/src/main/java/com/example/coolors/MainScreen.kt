package com.example.coolors

import android.widget.ImageView
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.coolors.ui.theme.CoolorsTheme
import androidx.compose.foundation.*
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import com.example.coolors.utils.ColorUtils.getColorHexString
import com.example.coolors.utils.ScreenUtils


@Composable
fun HomeScreen() {
    Surface(modifier = Modifier.fillMaxSize()) {
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            TitleDisplayer()
            ColorOperationsConsoleContainer()
        }
    }
}

@Composable
fun ColorOperationsConsoleContainer() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ConstraintLayout() {
            val (displayer, shuffleButton) = createRefs()
            ColorDisplayer(modifier = Modifier.constrainAs(displayer) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            })
            ShuffleButton(modifier = Modifier.constrainAs(shuffleButton) {
                top.linkTo(displayer.bottom)
                bottom.linkTo(displayer.bottom)
                start.linkTo(displayer.start)
                end.linkTo(displayer.end)
            })
        }
    }

}

@Composable
fun TitleDisplayer() {
    Box(
        modifier = Modifier
            .fillMaxWidth(0.7f)
            .padding(0.dp, 20.dp, 0.dp, 0.dp)
    ) {
        val imageToDisplay = if (!isSystemInDarkTheme())
            R.drawable.coolors_black_letters
        else R.drawable.coolors_white_letters
        Image(
            painter = painterResource(imageToDisplay),
            contentDescription = "Coolors logo",
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.Inside,
            alignment = Alignment.Center,
        )
    }
}

@Composable
fun ColorDisplayer(modifier: Modifier) {

    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .height(ScreenUtils.getFactorFromScreenHeight(0.5, LocalConfiguration.current))
            .width(ScreenUtils.getFactorFromScreenWidth(0.7, LocalConfiguration.current))
    ) {
        SingleColorDisplayer(Color.Blue, modifier = Modifier.weight(1f))
        SingleColorDisplayer(Color.Cyan, modifier = Modifier.weight(1f))
        SingleColorDisplayer(Color.Red, modifier = Modifier.weight(1f))
        SingleColorDisplayer(Color.Yellow, modifier = Modifier.weight(1f))
        SingleColorDisplayer(Color.Green, modifier = Modifier.weight(1f))
    }
}

@Composable
fun SingleColorDisplayer(color: Color, modifier: Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(color = color)
    ) {
        ConstraintLayout(modifier = Modifier.fillMaxSize()) {
            val (colorText, lockIcon) = createRefs()
            Text(
                text = getColorHexString(color, false), modifier = Modifier
                    .padding(8.dp)
                    .constrainAs(colorText) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                    },
                color = Color.White,
                style = MaterialTheme.typography.h2
            )
            Image(
                painter = painterResource(id = R.drawable.ic_baseline_lock_open_24),
                contentDescription = "Lock color icon",
                modifier = Modifier
                    .padding(8.dp)
                    .constrainAs(lockIcon) {
                        end.linkTo(parent.end)
                        bottom.linkTo(parent.bottom)
                    }
            )
        }
    }
}

@Composable
fun ShuffleButton(modifier: Modifier) {
    IconButton(
        onClick = { /*TODO*/ },
        modifier = modifier.then(
            Modifier
                .size(ScreenUtils.getFactorFromScreenHeight(0.1, LocalConfiguration.current))
                .background(Color.Blue, CircleShape)
        )
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_shuffle_black_24dp),
            contentDescription = "Blach",
            tint = Color.White,
            modifier = Modifier.fillMaxSize(0.5f)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    CoolorsTheme {
        HomeScreen()
    }
}