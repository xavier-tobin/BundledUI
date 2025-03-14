package com.xaviertobin.bundledui.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

fun buildCustomTypography(
    colorScheme: ColorScheme,
    font: FontFamily?,
    fontScale: Float
): Typography {
    return Typography(
        displayLarge = TextStyle(
            fontFamily = font,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp * fontScale,
            color = colorScheme.onSurfaceVariant
        ),
        displayMedium = TextStyle(
            fontFamily = font,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp * fontScale,
            color = colorScheme.onSurfaceVariant
        ),
        displaySmall = TextStyle(
            fontFamily = font,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp * fontScale,
            color = colorScheme.onSurfaceVariant
        ),
        headlineLarge = TextStyle(
            fontFamily = font,
            fontWeight = FontWeight.SemiBold,
            fontSize = 30.sp * fontScale,
            color = colorScheme.onSurfaceVariant
        ),
        headlineMedium = TextStyle(
            fontFamily = font,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp * fontScale,
            color = colorScheme.onSurfaceVariant
        ),
        headlineSmall = TextStyle(
            fontFamily = font,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp * fontScale,
            color = colorScheme.onSurfaceVariant
        ),
        titleLarge = TextStyle(
            fontFamily = font,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp * fontScale,
            color = colorScheme.onSurfaceVariant
        ),
        titleMedium = TextStyle(
            fontFamily = font,
            fontWeight = FontWeight.SemiBold,
            fontSize = 18.sp * fontScale,
            color = colorScheme.onSurfaceVariant
        ),
        titleSmall = TextStyle(
            fontFamily = font,
            fontWeight = FontWeight.Medium,
            fontSize = 16.sp * fontScale,
            color = colorScheme.onSurfaceVariant
        ),
        bodyLarge = TextStyle(
            fontFamily = font,
            fontWeight = FontWeight.Medium,
            fontSize = 15.sp * fontScale,
            color = colorScheme.onSurfaceVariant
        ),
        bodyMedium = TextStyle(
            fontFamily = font,
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp * fontScale,
            color = colorScheme.onSurfaceVariant
        ),
        bodySmall = TextStyle(
            fontFamily = font,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp * fontScale,
            color = colorScheme.onSurfaceVariant
        ),
        labelLarge = TextStyle(
            fontFamily = font,
            fontWeight = FontWeight.Medium,
            fontSize = 14.sp * fontScale,
            color = colorScheme.onSurfaceVariant
        ),
        labelMedium = TextStyle(
            fontFamily = font,
            fontWeight = FontWeight.Medium,
            fontSize = 12.sp * fontScale,
            color = colorScheme.onSurfaceVariant
        ),
        labelSmall = TextStyle(
            fontFamily = font,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp * fontScale,
            color = colorScheme.onSurfaceVariant
        ),
    )
}