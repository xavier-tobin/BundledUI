package com.xaviertobin.bundledui.section.extras

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.xaviertobin.bundledui.base.Tone
import com.xaviertobin.bundledui.base.iconColorForTone

@Composable
fun LoadingOrIcon(
    loadingFromClick: Boolean,
    icon: ImageVector? = null,
    tone: Tone,
    iconDescription: String,
    tint: Color = iconColorForTone(tone)
) {
    if (loadingFromClick) {
        CircularProgressIndicator(
            modifier = Modifier
                .padding(start = 10.dp)
                .size(20.dp),
            color = tint,
            strokeWidth = 3.dp
        )
    } else if (icon != null) {
        EndIcon(
            icon = icon,
            iconDescription = iconDescription,
            tint = tint
        )
    }
}

@Composable
fun EndIcon(
    icon: ImageVector,
    tint: Color,
    iconDescription: String,
) = Icon(
    imageVector = icon,
    contentDescription = iconDescription,
    tint = tint,
    modifier = Modifier
        .padding(start = 10.dp)
        .size(20.dp)
)
