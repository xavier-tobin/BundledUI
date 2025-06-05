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
    get() = Color(0xFFF0F0F0)

/**
 * Returns the complementary color on the Color wheel
 */
fun Color.rotateHue(by: Float = 180f): Color {
    val hsb = this.toHsb()
    return hsb.copy(
        hue = (hsb.hue + by) % 360
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

fun Color.perceivedLightness(): Float {
    val luminance = (0.299f * this.red + 0.587f * this.green + 0.114f * this.blue)
    return luminance.coerceIn(0.0f, 1.0f)
}


fun Color.getIntensityReduction(degree: Float = 0.25f) =
    (degree * this.perceivedLightness()).toFloat()

fun Int.modifyColorForTheme(theme: BaseTheme): Int {
    return when (theme) {
        BaseTheme.LIGHT -> this
        BaseTheme.DARK -> ColorUtils.blendARGB(this, android.graphics.Color.DKGRAY, 0.65f)
        BaseTheme.OLED -> ColorUtils.blendARGB(this, android.graphics.Color.BLACK, 0.62f)
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
        BaseTheme.DARK -> 1f - intensityGivenColor
        BaseTheme.OLED -> 0.9f - intensityGivenColor
    }

    return this.toHsb().copy(
        saturation = saturation.toFloat(),
        brightness = brightness
    ).toComposeColor()
}

fun Color.Companion.randomAestheticColor(): Color {
    val style = listOf("pastel", "vibrant", "other").random()
    val niceHueRanges = listOf(0f..35f, 75f..360f)

    val (saturation, brightness) = when (style) {
        "pastel" -> Pair((0.38f..0.55f).random(), (0.85f..0.9f).random())
        "vibrant" -> Pair((0.6f..0.9f).random(), (0.7f..0.85f).random())
        else -> Pair((0.5f..0.8f).random(), (0.6f..0.9f).random())
    }

    return HSBColor(
        hue = niceHueRanges.random().random(),
        saturation = saturation,
        brightness = brightness
    ).toComposeColor()
}

fun ClosedFloatingPointRange<Float>.random(): Float {
    return (start + Math.random() * (endInclusive - start)).toFloat()
}
