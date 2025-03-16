package com.xaviertobin.bundledui.color

import androidx.compose.ui.graphics.Color
import com.xaviertobin.bundledui.theme.BaseTheme

val Color.Companion.DarkerGray: Color
    get() = Color(0xFF222222)


fun test() {
    Color.DarkGray
}

val Color.Companion.LighterGray
    get() = Color(0xFFE0E0E0)

/**
 * Returns the complementary color on the Color wheel
 */
fun Color.complementaryColor(): Color {
    val hsb = this.toHsb()
    return hsb.copy(
        hue = (hsb.hue + 180f) % 360
    ).toComposeColor()
}

/**
 * Returns a color of the same hue, with a modified brightness & saturation
 */
fun Color.adjustTo(saturation: Float = 0.7f, brightness: Float = 0.7f): Color {
    return this.toHsb().copy(
        saturation = saturation,
        brightness = brightness
    ).toComposeColor()
}

fun Color.adjust(relativeSaturationBy: Float = 0.0f, relativeBrightnessBy: Float = 0.0f): Color {
    val current = this.toHsb()

    return current.copy(
        saturation = (current.saturation + relativeSaturationBy).coerceIn(0f, 1f),
        brightness = (current.brightness + relativeBrightnessBy).coerceIn(0f, 1f),
    ).toComposeColor()
}


/**
 * Reduces the brightness and saturation of a color based off its relative brightness/saturation
 */
fun Color.deintensify(by: Float = 0.12f): Color {
    return this.adjust(
        relativeBrightnessBy = -this.getIntensityReduction(by),
        relativeSaturationBy = -this.getIntensityReduction(by),
    )
}

fun Color.getIntensityReduction(degree: Float = 0.25f) =
    (((0.299 * this.red) + (0.587 * this.green) + (0.114 * this.blue)) * degree).toFloat()

fun Color.dulled(forTheme: BaseTheme): Color {
    // Want to add more saturation and brightness depending on the brightness of the color (i.e. green)
    val intensityGivenColor = this.getIntensityReduction(0.4f)

    val saturation = when (forTheme) {
        BaseTheme.LIGHT -> 0.9f - intensityGivenColor
        BaseTheme.DARK -> 0.7f - intensityGivenColor
        BaseTheme.OLED -> 0.85f - intensityGivenColor
    }

    val brightness = when (forTheme) {
        BaseTheme.LIGHT -> 0.75f - intensityGivenColor
        BaseTheme.DARK -> 0.95f - intensityGivenColor
        BaseTheme.OLED -> 0.85f - intensityGivenColor
    }

    return this.toHsb().copy(
        saturation = saturation.toFloat(),
        brightness = brightness
    ).toComposeColor()
}

fun Color.Companion.randomAestheticColor(): Color {

    val brightnessRange = 0.9f..1f

    val saturationRange = 0.6f..1f

    var hue: Float
    do {
        hue = (0f..360f).random()
    } while (hue in 48f..78f)

    return HSBColor(
        hue = hue.toFloat(),
        saturation = saturationRange.random(),
        brightness = brightnessRange.random()
    ).toComposeColor()
}

fun ClosedFloatingPointRange<Float>.random(): Float {
    return (start + Math.random() * (endInclusive - start)).toFloat()
}