package com.xaviertobin.bundledui.buttons

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.xaviertobin.bundledui.base.UnitFunction
import com.xaviertobin.bundledui.base.firstLastCornersChip
import com.xaviertobin.bundledui.base.maybeClickable
import com.xaviertobin.bundledui.color.alpha


object IconButtonDefaults {
    val margin = PaddingValues(end = 4.dp, top = 4.dp, bottom = 4.dp)
    val padding = PaddingValues(8.dp)
}

@Composable
fun IconButton(
    icon: ImageVector,
    contentDescription: String,
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.primary,
    margin: PaddingValues = IconButtonDefaults.margin,
    padding: PaddingValues = IconButtonDefaults.padding,
    size: Dp = 24.dp,
    backgroundColor: Color = Color.Transparent,
    enabled: Boolean = true,
    onClick: UnitFunction
) {
    Box(
        modifier = modifier
            .padding(margin)
            .clip(CircleShape)
            .background(
                color = backgroundColor,
                shape = CircleShape
            )
            .maybeClickable(
                enabled = enabled,
                onClick = onClick
            )
            .padding(padding)
    ) {
        Icon(
            imageVector = icon,
            contentDescription = contentDescription,
            tint = color,
            modifier = Modifier.size(size)
        )
    }
}


@Composable
fun SectionIconButton(
    icon: ImageVector,
    contentDescription: String,
    modifier: Modifier = Modifier,
    first: Boolean = false,
    last: Boolean = false,
    color: Color = MaterialTheme.colorScheme.primary,
    margin: PaddingValues = PaddingValues(
        end = 4.dp,
    ),
    padding: PaddingValues = PaddingValues(
        start = if (first) 10.dp else  8.dp,
        end = if (last) 10.dp else 8.dp,
        top = 8.dp,
        bottom = 8.dp
    ),
    backgroundColor: Color = MaterialTheme.colorScheme.tertiary.alpha(0.1f),
    enabled: Boolean = true,
    onClick: UnitFunction
) {

    val shape = firstLastCornersChip(
        first,
        last,
    )

    Box(
        modifier = modifier
            .padding(margin)
            .clip(shape)
            .background(
                color = backgroundColor,
                shape = shape
            )
            .clickable(
                enabled = enabled,
                onClick = onClick
            )
            .padding(padding)
    ) {
        Icon(
            imageVector = icon,
            contentDescription = contentDescription,
            tint = color,
        )
    }
}
