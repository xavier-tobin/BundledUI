package com.xaviertobin.bundledui.section.widgets

import androidx.compose.foundation.layout.RowScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import com.xaviertobin.bundledui.base.ToggleComposable
import com.xaviertobin.bundledui.base.Tone
import com.xaviertobin.bundledui.section.base.SectionOrientation
import com.xaviertobin.bundledui.section.base.sectionTextColorForTone


@Composable
fun SectionButtonSheet(
    title: String,
    icon: ImageVector,
    modifier: Modifier = Modifier,
    description: String? = null,
    first: Boolean = false,
    last: Boolean = false,
    selected: Boolean = false,
    tone: Tone = Tone.NEUTRAL,
    orientation: SectionOrientation = SectionOrientation.VERTICAL,
    textColor: Color = sectionTextColorForTone(selected, tone),
    sheetLayout: @Composable (onDismiss: () -> Unit) -> Unit
) {
    ToggleComposable(
        defaultContent = { onShow ->
            SectionButton(
                title = title,
                description = description,
                icon = icon,
                modifier = modifier,
                first = first,
                last = last,
                selected = selected,
                tone = tone,
                textColor = textColor,
                orientation = orientation,
                onClick = { onShow() }
            )
        },
        enabledContent = sheetLayout
    )
}

@Composable
fun RowScope.SectionButtonSheet(
    title: String,
    icon: ImageVector,
    modifier: Modifier = Modifier,
    description: String? = null,
    first: Boolean = false,
    last: Boolean = false,
    selected: Boolean = false,
    tone: Tone = Tone.NEUTRAL,
    textColor: Color = sectionTextColorForTone(selected, tone),
    sheetLayout: @Composable (onDismiss: () -> Unit) -> Unit
) = SectionButtonSheet(
    title = title,
    icon = icon,
    modifier = modifier,
    description = description,
    first = first,
    last = last,
    selected = selected,
    tone = tone,
    orientation = SectionOrientation.HORIZONTAL,
    textColor = textColor,
    sheetLayout = sheetLayout
)
