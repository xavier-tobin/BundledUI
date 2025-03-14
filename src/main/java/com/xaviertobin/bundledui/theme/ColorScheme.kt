package com.xaviertobin.bundledui.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.xaviertobin.bundledui.color.blend
import com.xaviertobin.bundledui.color.DarkerGray
import com.xaviertobin.bundledui.color.complementaryColor
import com.xaviertobin.bundledui.color.dulled
import com.xaviertobin.bundledui.color.normalizeSaturation


/**
 * Creates a usable Material3 ColorScheme with a neutral dark gray tone
 * If OLED, surface is set to black
 */
fun defaultDarkColorScheme(isOled: Boolean = false): ColorScheme  {
    return darkColorScheme(
        primary = Color.LightGray,
        secondary = Color.LightGray,
        tertiary = Color.LightGray,
        surface =  if (isOled) Color.Black else Color.DarkGray.blend(Color.Black, by = 0.7f),
        secondaryContainer = Color.DarkGray.blend(Color.Black, by = 0.3f),
        onPrimaryContainer = Color.White.blend(Color.LightGray, by = 0.4f),
        onSecondaryContainer = Color.White.blend(Color.LightGray, by = 0.3f),
        onSurfaceVariant = Color.White.blend(Color.LightGray, by = 0.25f),
        onPrimary = Color.Black.blend(Color.LightGray, by = 0.2f),
        surfaceContainer = Color.Black.blend(Color.LightGray, by = 0.3f),
    )
}

/**
 * Creates a usable Material3 ColorScheme with a neutral white/light gray tone
 * If OLED, surface is set to black
 */
fun defaultLightColorScheme() = lightColorScheme(
    primary = Color.DarkGray.blend(Color.Black, by = 0.2f),
    secondary = Color.DarkGray.blend(Color.Black, by = 0.2f),
    tertiary = Color.DarkGray.blend(Color.Black, by = 0.1f),
    surface = Color.White.blend(Color.LightGray, by = 0.1f),
    secondaryContainer = Color.White.blend(Color.LightGray, by = 0.7f),
    onSecondaryContainer = Color.Black.blend(Color.LightGray, by = 0.3f),
    onPrimaryContainer = Color.Black.blend(Color.LightGray, by = 0.3f),
    onSurfaceVariant = Color.Black.blend(Color.LightGray, by = 0.3f),
    onPrimary = Color.White.blend(Color.LightGray, by = 0.2f),
    surfaceContainer = Color.White.blend(Color.LightGray, by = 0.4f),
)


/**
 * Creates a light/dark/oled Material3 ColorScheme with a given primary and tertiary tone
 * If not supplied, the tertiary color is set to a complementary color from the primary color
 */
fun colorBasedColorScheme(
    primary: Color,
    tertiary: Color = primary.complementaryColor().dulled(),
    theme: BaseTheme
): ColorScheme {

    val actualPrimary = primary.normalizeSaturation()

    val baseTone = when (theme) {
        BaseTheme.LIGHT -> Color.White
        BaseTheme.DARK -> Color.DarkerGray
        BaseTheme.OLED -> Color.Black
    }

    val contrastTone = when (theme) {
        BaseTheme.LIGHT -> Color.DarkerGray
        BaseTheme.DARK -> Color.White
        BaseTheme.OLED -> Color.White
    }

    return when (theme) {

        BaseTheme.LIGHT -> lightColorScheme(
            primary = actualPrimary,
            secondary = actualPrimary,
            tertiary = tertiary,
            surface = baseTone.blend(actualPrimary, by = 0.005f),
            secondaryContainer = baseTone.blend(actualPrimary, by = 0.7f),
            onSecondaryContainer = actualPrimary.blend(baseTone, by = 0.3f),
            onPrimaryContainer = actualPrimary.blend(baseTone, by = 0.3f),
            onSurfaceVariant = contrastTone.blend(actualPrimary, by = 0.28f),
            onPrimary = baseTone.blend(actualPrimary, by = 0.2f),
            surfaceContainer = actualPrimary.blend(baseTone, by = 0.4f),
            surfaceTint = actualPrimary
        )

        BaseTheme.DARK -> darkColorScheme(
            primary = actualPrimary,
            secondary = actualPrimary,
            tertiary = tertiary,
            surface = baseTone.blend(actualPrimary, by = 0.04f),
            secondaryContainer = baseTone.blend(actualPrimary, by = 0.3f),
            onPrimaryContainer = actualPrimary.blend(baseTone, by = 0.4f),
            onSecondaryContainer = actualPrimary.blend(baseTone, by = 0.3f),
            onSurfaceVariant = contrastTone.blend(actualPrimary, by = 0.2f),
            onPrimary = baseTone.blend(actualPrimary, by = 0.2f),
            surfaceContainer = actualPrimary.blend(baseTone, by = 0.3f),
            surfaceTint = actualPrimary
        )

        BaseTheme.OLED -> darkColorScheme(
            primary = actualPrimary,
            secondary = actualPrimary,
            tertiary = tertiary,
            surface = baseTone.blend(actualPrimary, by = 0.04f),
            secondaryContainer = baseTone.blend(actualPrimary, by = 0.3f),
            onPrimaryContainer = actualPrimary.blend(baseTone, by = 0.4f),
            onSecondaryContainer = actualPrimary.blend(baseTone, by = 0.3f),
            onSurfaceVariant = contrastTone.blend(actualPrimary, by = 0.2f),
            onPrimary = baseTone.blend(actualPrimary, by = 0.2f),
            surfaceContainer = actualPrimary.blend(baseTone, by = 0.3f),
            surfaceTint = actualPrimary
        )
    }
}


/**
 * This is commonly used, easier than specifying the elevation each time
 */
fun ColorScheme.elevatedSurface() = this.surfaceColorAtElevation(12.dp)

/**
 * This ensures that surface stays OLED-safe
 */
fun ColorScheme.safeSurface() =
    if (this.surface == Color.Black) this.surface else this.surfaceColorAtElevation(0.5.dp)