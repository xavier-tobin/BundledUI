package com.xaviertobin.bundledui.section.base

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

fun smartCornersChip(
    first: Boolean = false,
    last: Boolean = false,
    defaultCornerRadius: Dp = 5.dp,
    pronouncedCornerRadius: Dp = 22.dp,
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

fun firstLastCorners(
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
