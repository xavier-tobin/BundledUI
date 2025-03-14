package com.xaviertobin.bundledui.color

import androidx.compose.ui.graphics.Color

fun Int.toComposeColor(): Color {
    return Color(this)
}

fun HSBColor.toComposeColor() : Color {
    return Color(android.graphics.Color.HSVToColor(floatArrayOf(hue, saturation, brightness)))
}