package com.xaviertobin.bundledui.color

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb

data class HSBColor(val hue: Float, val saturation: Float, val brightness: Float)

fun Color.toHsb() : HSBColor {
    val floatArray = FloatArray(3)
    android.graphics.Color.colorToHSV(this.toArgb(), floatArray)
    return HSBColor(
        hue = floatArray[0],
        saturation = floatArray[1],
        brightness = floatArray[2]
    )
}

