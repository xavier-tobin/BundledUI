package com.xaviertobin.bundledui.buttons

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.xaviertobin.bundledui.base.UnitFunction


object IconButtonDefaults {
    val margin = PaddingValues(end = 4.dp, top = 4.dp, bottom = 4.dp)
    val padding = PaddingValues(8.dp)
}

@Composable
fun IconButton(
    icon: ImageVector,
    contentDescription: String,
    modifier: Modifier = Modifier,
    tint: Color = MaterialTheme.colorScheme.primary,
    margin: PaddingValues = IconButtonDefaults.margin,
    padding: PaddingValues = IconButtonDefaults.padding,
    onClick: UnitFunction
) {
    Box(modifier = modifier
        .padding(margin)
        .clip(CircleShape)
        .clickable {
            onClick()
        }
        .padding(padding)
    ) {
        Icon(
            imageVector = icon,
            contentDescription = contentDescription,
            tint = tint,
        )
    }
}
