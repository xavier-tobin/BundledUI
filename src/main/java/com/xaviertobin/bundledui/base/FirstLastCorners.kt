package com.xaviertobin.bundledui.base

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * Provides a shape to round the first and last Sections in a column (by default).
 */
@Composable
fun firstLastCornersVertical(
    first: Boolean = false,
    last: Boolean = false,
    defaultCornerRadius: Dp = 6.dp,
    pronouncedCornerRadius: Dp = 32.dp,
): RoundedCornerShape {
    val topCorners by animateDpAsState(if (first) pronouncedCornerRadius else defaultCornerRadius, label = "topCorners")
    val bottomCorners by animateDpAsState( if (last) pronouncedCornerRadius else defaultCornerRadius, label = "bottomCorners")
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
@Composable
fun firstLastCornersHorizontal(
    first: Boolean = false,
    last: Boolean = false,
    defaultCornerRadius: Dp = 9.dp,
    pronouncedCornerRadius: Dp = 32.dp,
): RoundedCornerShape {
    val startCorners by animateDpAsState(if (first) pronouncedCornerRadius else defaultCornerRadius, label = "startCorners")
    val endCorners by animateDpAsState(if (last) pronouncedCornerRadius else defaultCornerRadius, label = "endCorners")
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
@Composable
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

fun RoundedCornerShape.adjustForParent(
    first: Boolean,
    last: Boolean,
    defaultCornerRadius: Dp = 9.dp,
): RoundedCornerShape = this.copy(
    bottomStart = if (!last) CornerSize(defaultCornerRadius) else this.bottomStart,
    bottomEnd = if (!last) CornerSize(defaultCornerRadius) else this.bottomEnd,
    topStart = if (!first) CornerSize(defaultCornerRadius) else this.topStart,
    topEnd = if (!first) CornerSize(defaultCornerRadius) else this.topEnd,
)