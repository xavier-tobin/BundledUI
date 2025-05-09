package com.xaviertobin.bundledui.section.widgets

import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import com.xaviertobin.bundledui.base.ToggleComposable
import com.xaviertobin.bundledui.base.Tone
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
                onClick = { onShow() }
            )
        },
        enabledContent = sheetLayout
    )
}
