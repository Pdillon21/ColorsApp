package com.example.coolors.utils

import android.content.res.Configuration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

object ScreenUtils {

    fun getFactorFromScreenHeight(factor: Double, currentLocalConfig: Configuration) : Dp {
        val currentScreenHeight = currentLocalConfig.screenHeightDp
        return (currentScreenHeight * factor).dp
    }

    fun getFactorFromScreenWidth(factor: Double, currentLocalConfig: Configuration): Dp {
        val currentScreenWidth = currentLocalConfig.screenWidthDp
        return (currentScreenWidth * factor).dp
    }

}