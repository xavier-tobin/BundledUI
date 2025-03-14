package com.xaviertobin.bundledui.color

import androidx.compose.ui.graphics.Color
import com.xaviertobin.bundledui.theme.BaseTheme

val Color.Companion.DarkerGray: Color
    get() = Color(0xFF161616)

val Color.Companion.LighterGray
    get() = Color(0xFFE0E0E0)

fun Color.complementaryColor(): Color {
    val hsb = this.toHsb()
    return hsb.copy(
        hue = (hsb.hue + 180f) % 360
    ).toComposeColor()
}

fun Color.normalizeSaturation(to: Float = 0.7f): Color {
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

fun Color.dulled(forTheme: BaseTheme): Color {

    // Want to add more saturation and brightness depending on the brightness of the color (i.e. green)
    val intensityGivenColor =
        ((0.299 * this.red) + (0.587 * this.green) + (0.114 * this.blue)) * 0.22f

    val saturation = when (forTheme) {
        BaseTheme.LIGHT -> 0.7f - intensityGivenColor
        BaseTheme.DARK -> 0.8f - intensityGivenColor
        BaseTheme.OLED -> 0.85f - intensityGivenColor
    }

    val brightness = when (forTheme) {
        BaseTheme.LIGHT -> 0.65f
        BaseTheme.DARK -> 0.7f
        BaseTheme.OLED -> 0.7f
    }

    return this.toHsb().copy(
        saturation = saturation.toFloat(),
        brightness = brightness
    ).toComposeColor()
}

