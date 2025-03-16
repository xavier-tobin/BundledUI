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
    icon: ImageVector,
    tone: Tone,
    iconDescription: String,
    tint: Color = iconColorForTone(tone)
) {
    if (loadingFromClick) {
        CircularProgressIndicator(
            modifier = Modifier.Companion
                .padding(end = 6.dp)
                .size(24.dp),
            color = tint
        )
    } else {
        Icon(
            modifier = Modifier.Companion.padding(end = 6.dp),
            imageVector = icon,
            contentDescription = iconDescription,
            tint = tint
        )
    }
}