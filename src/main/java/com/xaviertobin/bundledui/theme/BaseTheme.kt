package com.xaviertobin.bundledui.theme

import android.content.Context
import android.content.res.Configuration
import android.content.res.Configuration.UI_MODE_NIGHT_YES

/**
 * In reality, themes involve other settings or properties, like tint or system respect settings.
 * This enum is used to represent the *current* base theme.
 *
 * A real theme setting might be: "Material You enabled + Respect system theme + Use OLED for dark"
 * If the system is in dark mode, the base theme for the above is OLED
 * If the system is in light mode, the base theme for the above is LIGHT
 *
 * If using BundledUI, you will need to do the work to derive the base theme from your preferences
 */
enum class BaseTheme {
    LIGHT,
    DARK,
    OLED
}

/**
 * This is a helpful util to determine if the system is in dark mode, but use the Compose version where possible
 */
fun Context.isSystemInDarkTheme(): Boolean {
    return (this.resources.configuration.uiMode and
            Configuration.UI_MODE_NIGHT_MASK) == UI_MODE_NIGHT_YES
}
