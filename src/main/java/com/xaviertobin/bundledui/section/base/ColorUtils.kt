package com.xaviertobin.bundledui.section.base

import androidx.annotation.FloatRange
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.core.graphics.ColorUtils


fun Color.alpha(alpha: Float): Color {
    return this.copy(alpha = alpha)
}

fun Color.blend(to: Color, @FloatRange(0.0, 1.0) by: Float): Color {
    return Color(ColorUtils.blendARGB(this.toArgb(), to.toArgb(), by))
}