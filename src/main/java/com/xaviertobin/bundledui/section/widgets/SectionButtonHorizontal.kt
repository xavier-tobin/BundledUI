package com.xaviertobin.bundledui.section.widgets

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.xaviertobin.bundledui.base.UnitFunction
import com.xaviertobin.bundledui.base.firstLastCornersChip
import com.xaviertobin.bundledui.section.base.Section


// TODO remove in favour of using SectionButton with orientation = horizontal
@Composable
fun SectionButtonHorizontal(
    text: String,
    description: String? = null,
    icon: ImageVector,
    first: Boolean = false,
    last: Boolean = false,
    selected: Boolean = false,
    warning: Boolean = false,
    onClick: UnitFunction,
) {

    val textColor = if (selected) {
        MaterialTheme.colorScheme.surface
    } else if (warning) {
        MaterialTheme.colorScheme.error
    } else {
        MaterialTheme.colorScheme.onSurfaceVariant
    }

    val selectedExtraPadding by animateDpAsState(
        targetValue = if (selected) 5.dp else 0.dp,
        label = "selectedExtraPadding",
    )

    Section(
        first = first,
        last = last,
        onClick = onClick,
        containerColor = if (selected) MaterialTheme.colorScheme.tertiary else MaterialTheme.colorScheme.surfaceColorAtElevation(12.dp),
        padding = PaddingValues(
            start = if (first) 24.dp else 20.dp,
            end = if (last) 24.dp else 20.dp,
            top = 12.dp + selectedExtraPadding,
            bottom = 12.dp + selectedExtraPadding,
        ),
        margin = PaddingValues(
            end = 5.dp + selectedExtraPadding,
            start = selectedExtraPadding,
            top = 5.dp - selectedExtraPadding,
            bottom = 5.dp - selectedExtraPadding,
        ),
        shape = firstLastCornersChip(
            first = first,
            last = last,
            pronouncedCornerRadius = 28.dp + selectedExtraPadding,
            defaultCornerRadius = 6.dp + selectedExtraPadding
        )
    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                modifier = Modifier
                    .padding(bottom = 8.dp)
                    .size(22.dp),
                imageVector = icon,
                contentDescription = description ?: text,
                tint = if (warning) MaterialTheme.colorScheme.error else if (selected) textColor else MaterialTheme.colorScheme.tertiary
            )
            Text(
                text = text,
                style = MaterialTheme.typography.bodyLarge,
                color = textColor,
                textAlign = TextAlign.Start,
            )
            description?.let {
                Text(
                    modifier = Modifier
                        .padding(top = 2.dp),
                    text = description,
                    style = MaterialTheme.typography.bodySmall,
                    color = textColor,
                    textAlign = TextAlign.Start,
                    fontSize = 11.sp
                )
            }
        }
    }
}
