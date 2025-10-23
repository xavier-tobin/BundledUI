package com.xaviertobin.bundledui.color

import androidx.compose.ui.graphics.Color

fun Int.toColor(): Color {
    return Color(this)
}

fun HSBColor.toColor(
    hue: Float = this.hue,
    saturation: Float = this.saturation,
    brightness: Float = this.brightness
) : Color {
    return Color(android.graphics.Color.HSVToColor(floatArrayOf(hue, saturation, brightness)))
}