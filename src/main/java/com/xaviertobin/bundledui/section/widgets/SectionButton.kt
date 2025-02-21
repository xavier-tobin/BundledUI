package com.xaviertobin.bundledui.section.widgets


import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.AnnotatedString
import com.xaviertobin.bundledui.section.base.Tone
import com.xaviertobin.bundledui.section.base.UnitFunction
import com.xaviertobin.bundledui.section.section.sectionTextColorForTone

/**
 * SectionButtons are large clickable surfaces to designate significant actions, usually on a scrolling page or modal
 */
@Composable
fun SectionButton(
    text: String,
    icon: ImageVector,
    modifier: Modifier = Modifier,
    description: AnnotatedString? = null,
    first: Boolean = false,
    last: Boolean = false,
    selected: Boolean = false,
    tone: Tone = Tone.NEUTRAL,
    textColor: Color = sectionTextColorForTone(selected, tone),
    loadingFromClick: Boolean = false,
    onLongClick: UnitFunction? = null,
    onClick: UnitFunction,
) = SectionTextDescriptionIcon(
    first = first,
    last = last,
    onClick = onClick,
    selected = selected,
    modifier = modifier,
    text = text,
    description = description,
    onLongClick = onLongClick,
    icon = icon,
    loadingFromClick = loadingFromClick,
    tone = tone,
    textColor = textColor,
)


@Composable
fun SectionButton(
    text: String,
    icon: ImageVector,
    modifier: Modifier = Modifier,
    first: Boolean = false,
    last: Boolean = false,
    selected: Boolean = false,
    tone: Tone = Tone.NEUTRAL,
    textColor: Color = sectionTextColorForTone(selected, tone),
    loadingFromClick: Boolean = false,
    onLongClick: UnitFunction? = null,
    onClick: UnitFunction,
) = SectionTextDescriptionIcon(
    first = first,
    last = last,
    onClick = onClick,
    onLongClick = onLongClick,
    selected = selected,
    modifier = modifier,
    text = text,
    description = null,
    icon = icon,
    tone = tone,
    textColor = textColor,
    loadingFromClick = loadingFromClick
)

@Composable
fun SectionButton(
    text: String,
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
) = SectionButton(
    first = first,
    last = last,
    onClick = onClick,
    onLongClick = onLongClick,
    selected = selected,
    modifier = modifier,
    text = text,
    description = if (description != null) AnnotatedString(description) else null,
    icon = icon,
    tone = tone,
    textColor = textColor,
    loadingFromClick = loadingFromClick
)
