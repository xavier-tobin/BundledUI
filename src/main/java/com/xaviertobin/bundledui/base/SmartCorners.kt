package com.xaviertobin.bundledui.base

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * Provides a shape to round the first and last Sections in a column (by default).
 */
fun firstLastCornersVertical(
    first: Boolean = false,
    last: Boolean = false,
    defaultCornerRadius: Dp = 9.dp,
    pronouncedCornerRadius: Dp = 32.dp,
): RoundedCornerShape {
    val topCorners = if (first) pronouncedCornerRadius else defaultCornerRadius
    val bottomCorners = if (last) pronouncedCornerRadius else defaultCornerRadius
    return RoundedCornerShape(
        topStart = topCorners,
        topEnd = topCorners,
        bottomStart = bottomCorners,
        bottomEnd = bottomCorners
    )
}

/**
 * Provides a shape to round the first and last Sections in a row (by default).
 */
fun firstLastCornersHorizontal(
    first: Boolean = false,
    last: Boolean = false,
    defaultCornerRadius: Dp =  9.dp,
    pronouncedCornerRadius: Dp = 32.dp,
): RoundedCornerShape {
    val startCorners = if (first) pronouncedCornerRadius else defaultCornerRadius
    val endCorners = if (last) pronouncedCornerRadius else defaultCornerRadius
    return RoundedCornerShape(
        topStart = startCorners,
        topEnd = endCorners,
        bottomStart = startCorners,
        bottomEnd = endCorners
    )
}

/**
 * Provides a shape to round the first and last Chips in a row (by default).
 */
fun firstLastCornersChip(
    first: Boolean = false,
    last: Boolean = false,
    defaultCornerRadius: Dp = 5.dp,
    pronouncedCornerRadius: Dp = 22.dp,
) = firstLastCornersHorizontal(
    first = first,
    last = last,
    defaultCornerRadius = defaultCornerRadius,
    pronouncedCornerRadius = pronouncedCornerRadius
)

