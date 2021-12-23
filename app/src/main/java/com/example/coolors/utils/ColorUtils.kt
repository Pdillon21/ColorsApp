package com.example.coolors.utils

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import java.lang.StringBuilder

object ColorUtils {

    fun getColorHexString(color: Color, withAlpha: Boolean): kotlin.String {
        val alpha = android.graphics.Color.alpha(color.toArgb())
        val blue = android.graphics.Color.blue(color.toArgb())
        val green = android.graphics.Color.green(color.toArgb())
        val red = android.graphics.Color.red(color.toArgb())

        val alphaHex: kotlin.String = to00Hex(alpha)
        val blueHex: kotlin.String = to00Hex(blue)
        val greenHex: kotlin.String = to00Hex(green)
        val redHex: kotlin.String = to00Hex(red)

        val str = StringBuilder("#")
        if (withAlpha) {
            str.append(alphaHex)
        }
        str.append(redHex)
        str.append(greenHex)
        str.append(blueHex)
        return str.toString()
    }

    private fun to00Hex(value: Int): kotlin.String {
        val hex = "00" + Integer.toHexString(value)
        return hex.substring(hex.length - 2, hex.length)
    }
}
