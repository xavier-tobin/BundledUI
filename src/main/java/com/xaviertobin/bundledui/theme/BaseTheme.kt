package com.xaviertobin.bundledui.theme

import android.content.Context
import android.content.res.Configuration
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable

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

enum class BaseThemeSetting {
    LIGHT,
    DARK,
    OLED,
    SYSTEM_PREFER_DARK,
    SYSTEM_PREFER_OLED
}

@Composable
fun getBaseThemeFromSetting(setting: BaseThemeSetting): BaseTheme {

    return when (setting) {
        BaseThemeSetting.LIGHT -> BaseTheme.LIGHT
        BaseThemeSetting.DARK -> BaseTheme.DARK
        BaseThemeSetting.OLED -> BaseTheme.OLED
        BaseThemeSetting.SYSTEM_PREFER_DARK -> {
            if (isSystemInDarkTheme()) BaseTheme.DARK else BaseTheme.LIGHT
        }
        BaseThemeSetting.SYSTEM_PREFER_OLED -> {
            if (isSystemInDarkTheme()) BaseTheme.OLED else BaseTheme.LIGHT
        }
    }

}

/**
 * This is a helpful util to determine if the system is in dark mode, but use the Compose version where possible
 */
fun Context.isSystemInDarkTheme(): Boolean {
    return (this.resources.configuration.uiMode and
            Configuration.UI_MODE_NIGHT_MASK) == UI_MODE_NIGHT_YES
}
