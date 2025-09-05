package com.xaviertobin.bundledui.base

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.xaviertobin.bundledui.color.blend
import com.xaviertobin.bundledui.theme.text

enum class Tone {
    NEGATIVE, WARNING, NEUTRAL, POSITIVE,
}

val baseWarningColor = Color(
    0xffffb624
)

@Composable
fun textWarningColor() = MaterialTheme.colorScheme.text.blend(
    to = baseWarningColor,
    by = 0.2f
)

@Composable
fun textErrorColor() = MaterialTheme.colorScheme.text.blend(
    to = MaterialTheme.colorScheme.error,
    by = 0.5f
)

@Composable
fun vividTextColorForTone(tone: Tone) = when (tone) {
    Tone.POSITIVE -> MaterialTheme.colorScheme.surface
    Tone.NEUTRAL -> MaterialTheme.colorScheme.primary
    Tone.NEGATIVE -> MaterialTheme.colorScheme.surface
    Tone.WARNING -> MaterialTheme.colorScheme.error
}

// Vivid container colours are for small, primary, eye-catching components - like a button
@Composable
fun vividContainerColorForTone(tone: Tone) = when (tone) {
    Tone.POSITIVE -> MaterialTheme.colorScheme.primary
    Tone.NEUTRAL -> MaterialTheme.colorScheme.surfaceColorAtElevation(12.dp)
    Tone.NEGATIVE -> textErrorColor()
    Tone.WARNING -> MaterialTheme.colorScheme.errorContainer
}

// Standard container colours are for large, neutral components - like Sections
@Composable
fun containerColorForTone(tone: Tone) = when (tone) {
    Tone.POSITIVE -> MaterialTheme.colorScheme.primary
    Tone.NEUTRAL -> MaterialTheme.colorScheme.surfaceColorAtElevation(12.dp)
    Tone.NEGATIVE -> MaterialTheme.colorScheme.surfaceColorAtElevation(8.dp).blend(
        to = Color.Red,
        by = 0.11f
    )
    Tone.WARNING -> MaterialTheme.colorScheme.surfaceColorAtElevation(8.dp).blend(
        to = baseWarningColor,
        by = 0.13f
    )
}


@Composable
fun textColorForTone(tone: Tone) = when (tone) {
    Tone.POSITIVE -> MaterialTheme.colorScheme.surface
    Tone.NEUTRAL -> MaterialTheme.colorScheme.text
    Tone.NEGATIVE -> textErrorColor()
    Tone.WARNING -> textWarningColor()
}

@Composable
fun iconColorForTone(tone: Tone) = when (tone) {
    Tone.POSITIVE -> MaterialTheme.colorScheme.surface
    Tone.NEUTRAL -> MaterialTheme.colorScheme.tertiary
    Tone.NEGATIVE -> textErrorColor()
    Tone.WARNING -> textWarningColor()
}