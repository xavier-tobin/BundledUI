package com.xaviertobin.bundledui.color

import androidx.compose.ui.graphics.Color
import androidx.core.graphics.ColorUtils
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

fun Color.deintensifySaturation(by: Float = 0.12f): Color {
    return this.adjust(
        relativeSaturationBy = -this.getIntensityReduction(by),
    )
}

fun Color.deintensifyBrightness(by: Float = 0.12f): Color {
    return this.adjust(
        relativeBrightnessBy = -this.getIntensityReduction(by),
    )
}


fun Color.deintensify(by: Float = 0.12f): Color {
    return this.adjust(
        relativeBrightnessBy = -this.getIntensityReduction(by),
        relativeSaturationBy = -this.getIntensityReduction(by),
    )
}

fun Color.getIntensityReduction(degree: Float = 0.25f) =
    (((0.199 * this.red) + (0.587 * this.green) + (0.214 * this.blue)) * degree).toFloat()

fun Int.modifyColorForTheme(theme: BaseTheme): Int {
    return when (theme) {
        BaseTheme.LIGHT -> this
        BaseTheme.DARK -> ColorUtils.blendARGB(this, android.graphics.Color.DKGRAY, 0.6f)
        BaseTheme.OLED -> ColorUtils.blendARGB(this, android.graphics.Color.BLACK, 0.7f)
    }
}


fun Color.dulled(forTheme: BaseTheme, by: Float = 0.4f): Color {
    // Want to add more saturation and brightness depending on the brightness of the color (i.e. green)
    val intensityGivenColor = this.getIntensityReduction(by)

    val saturation = when (forTheme) {
        BaseTheme.LIGHT -> 0.86f - intensityGivenColor
        BaseTheme.DARK -> 0.8f - intensityGivenColor
        BaseTheme.OLED -> 0.87f - intensityGivenColor
    }

    val brightness = when (forTheme) {
        BaseTheme.LIGHT -> 0.84f - intensityGivenColor
        BaseTheme.DARK -> 0.95f - intensityGivenColor
        BaseTheme.OLED -> 0.9f - intensityGivenColor
    }

    return this.toHsb().copy(
        saturation = saturation.toFloat(),
        brightness = brightness
    ).toComposeColor()
}

fun Color.Companion.randomAestheticColor(): Color {

    var hue: Float
    do {
        hue = (0f..360f).random()
    } while (hue in 50f..70f)

    return HSBColor(
        hue = hue.toFloat(),
        saturation = (0.55f..0.93f).random(),
        brightness = (0.8f..0.9f).random()
    ).toComposeColor().deintensifyBrightness(by = 0.1f)
}

fun ClosedFloatingPointRange<Float>.random(): Float {
    return (start + Math.random() * (endInclusive - start)).toFloat()
}