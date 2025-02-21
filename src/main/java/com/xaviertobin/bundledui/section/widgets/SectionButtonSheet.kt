package com.xaviertobin.bundledui.section.widgets

import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import com.xaviertobin.bundledui.section.base.Tone
import com.xaviertobin.bundledui.section.section.sectionTextColorForTone

/**
 * SectionButtons are large clickable surfaces to designate significant actions, usually on a scrolling page or modal
 */
@Composable
fun SectionButtonSheet(
    @StringRes text: Int,
    icon: ImageVector,
    modifier: Modifier = Modifier,
    @StringRes description: Int? = null,
    first: Boolean = false,
    last: Boolean = false,
    selected: Boolean = false,
    tone: Tone = Tone.NEUTRAL,
    textColor: Color = sectionTextColorForTone(selected, tone),
    sheetLayout: @Composable (onDismiss: () -> Unit) -> Unit
) = SectionButtonSheet(
    text = stringResource(text),
    icon = icon,
    modifier = modifier,
    description = if (description != null) stringResource(id = description) else null,
    first = first,
    last = last,
    selected = selected,
    tone = tone,
    textColor = textColor,
    sheetLayout = sheetLayout
)

@Composable
fun SectionButtonSheet(
    text: String,
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

    var showSheet by remember { mutableStateOf(false) }

    SectionButton(
        first = first,
        last = last,
        selected = selected,
        modifier = modifier,
        title = text,
        description = description,
        icon = icon,
        tone = tone,
        textColor = textColor,
    ) {
        showSheet = true
    }

    if (showSheet) {
        sheetLayout { showSheet = false }
    }

}