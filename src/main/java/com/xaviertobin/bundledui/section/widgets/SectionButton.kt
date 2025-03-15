package com.xaviertobin.bundledui.section.widgets


import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import com.xaviertobin.bundledui.base.Tone
import com.xaviertobin.bundledui.base.UnitFunction
import com.xaviertobin.bundledui.section.base.SectionDefaults
import com.xaviertobin.bundledui.section.extras.LoadingOrIcon
import com.xaviertobin.bundledui.section.base.sectionTextColorForTone


@Composable
fun SectionButton(
    title: String,
    icon: ImageVector,
    modifier: Modifier = Modifier,
    description: String? = null,
    first: Boolean = false,
    last: Boolean = false,
    selected: Boolean = false,
    tone: Tone = Tone.NEUTRAL,
    textColor: Color = sectionTextColorForTone(selected, tone),
    loadingFromClick: Boolean = false,
    onLongClick: UnitFunction? = null,
    onClick: UnitFunction,
) = SectionTitleDescription(
    first = first,
    last = last,
    onClick = onClick,
    selected = selected,
    modifier = modifier,
    title = title,
    description = description,
    onLongClick = onLongClick,
    tone = tone,
    textColor = textColor,
    contentEnd = {
        LoadingOrIcon(
            loadingFromClick = loadingFromClick,
            icon = icon,
            tone = tone,
            iconDescription = title,
            tint = SectionDefaults.iconColor(
                selected = selected,
                tone = tone
            )
        )
    }
)
