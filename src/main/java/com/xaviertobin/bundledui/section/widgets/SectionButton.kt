package com.xaviertobin.bundledui.section.widgets


import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import com.xaviertobin.bundledui.base.Tone
import com.xaviertobin.bundledui.base.UnitFunction
import com.xaviertobin.bundledui.section.base.SectionDefaults
import com.xaviertobin.bundledui.section.base.SectionOrientation
import com.xaviertobin.bundledui.section.base.sectionTextColorForTone
import com.xaviertobin.bundledui.section.extras.LoadingOrIcon


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
    orientation: SectionOrientation = SectionOrientation.VERTICAL,
    containerColor : Color = SectionDefaults.containerColor(
        selected = selected,
        focused = false,
        tone = tone
    ),
    margin: PaddingValues = SectionDefaults.marginValues(
        orientation = orientation,
        last = last
    ),
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
    containerColor = containerColor,
    textColor = textColor,
    orientation = orientation,
    margin = margin,
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

@Composable
fun RowScope.SectionButton(
    title: String,
    icon: ImageVector,
    modifier: Modifier = Modifier,
    description: String? = null,
    first: Boolean = false,
    last: Boolean = false,
    selected: Boolean = false,
    tone: Tone = Tone.NEUTRAL,
    containerColor : Color = SectionDefaults.containerColor(
        selected = selected,
        focused = false,
        tone = tone
    ),
    textColor: Color = sectionTextColorForTone(selected, tone),
    loadingFromClick: Boolean = false,
    onLongClick: UnitFunction? = null,
    onClick: UnitFunction,
) = SectionButton(
    title = title,
    icon = icon,
    modifier = modifier,
    description = description,
    first = first,
    last = last,
    selected = selected,
    tone = tone,
    orientation = SectionOrientation.HORIZONTAL,
    containerColor = containerColor,
    textColor = textColor,
    loadingFromClick = loadingFromClick,
    onLongClick = onLongClick,
    onClick = onClick
)
