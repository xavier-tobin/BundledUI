package com.xaviertobin.bundledui.color

import androidx.compose.ui.graphics.Color

val Color.Companion.DarkerGray: Color
    get() = Color(0xFF141414)

val Color.Companion.LighterGray
    get() = Color(0xFFE0E0E0)

fun Color.complementaryColor(): Color {
    val hsb = this.toHsb()
    return hsb.copy(
        hue = (hsb.hue + 180f) % 360
    ).toComposeColor()
}

fun Color.normalizeSaturation(to: Float = 0.8f): Color {
    return this.toHsb().copy(
        saturation = to
    ).toComposeColor()
}

fun Color.dulled(to: Float = 0.7f): Color {
    return this.toHsb().copy(
        saturation = to,
        brightness = to
    ).toComposeColor()
}

