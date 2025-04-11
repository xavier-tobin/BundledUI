package com.xaviertobin.bundledui.section.extras

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.xaviertobin.bundledui.animations.AnimateInHorizontally
import com.xaviertobin.bundledui.base.Tone
import com.xaviertobin.bundledui.base.iconColorForTone

@Composable
fun LoadingOrIcon(
    loadingFromClick: Boolean,
    icon: ImageVector? = null,
    tone: Tone,
    iconDescription: String,
    tint: Color = iconColorForTone(tone),
    size: Dp = 24.dp,
    endPadding: Dp = 6.dp
) {
    AnimateInHorizontally(visible = loadingFromClick || icon != null) {
        if (loadingFromClick) {
            CircularProgressIndicator(
                modifier = Modifier
                    .padding(start = 10.dp, end = endPadding)
                    .size(size),
                color = tint,
                strokeWidth = 3.dp
            )
        } else if (icon != null) {
            EndIcon(
                icon = icon,
                iconDescription = iconDescription,
                color = tint,
                size = size,
                endPadding = endPadding
            )
        }
    }
}

@Composable
fun EndIcon(
    icon: ImageVector,
    color: Color,
    iconDescription: String,
    size: Dp = 24.dp,
    endPadding: Dp = 6.dp
) = Icon(
    imageVector = icon,
    contentDescription = iconDescription,
    tint = color,
    modifier = Modifier
        .padding(start = 10.dp, end = endPadding)
        .size(size)
)
