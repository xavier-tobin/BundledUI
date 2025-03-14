package com.xaviertobin.bundledui.section.widgets

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.xaviertobin.bundledui.base.ComposableFunction
import com.xaviertobin.bundledui.base.Tone
import com.xaviertobin.bundledui.base.UnitFunction
import com.xaviertobin.bundledui.base.iconColorForTone
import com.xaviertobin.bundledui.section.section.Section
import com.xaviertobin.bundledui.section.section.sectionTextColorForTone


@Composable
fun SectionTitleDescriptionIcon(
    title: String,
    modifier: Modifier = Modifier,
    description: String? = null,
    first: Boolean = false,
    last: Boolean = false,
    selected: Boolean = false,
    tone: Tone = Tone.NEUTRAL,
    textColor: Color = sectionTextColorForTone(selected, tone),
    icon: ImageVector,
    verticalPadding: Dp = 8.dp,
) {
    SectionTitleDescription(
        title = title,
        description = description,
        first = first,
        last = last,
        selected = selected,
        tone = tone,
        textColor = textColor,
        contentEnd = {
            Icon(
                modifier = Modifier.padding(end = 6.dp),
                imageVector = icon,
                contentDescription = title,
                tint = iconColorForTone(tone)
            )
        },
        modifier = modifier,
        verticalPadding = verticalPadding,
    )
}


@Composable
fun SectionTitleDescription(
    title: String,
    modifier: Modifier = Modifier,
    description: String? = null,
    first: Boolean = false,
    last: Boolean = false,
    selected: Boolean = false,
    tone: Tone = Tone.NEUTRAL,
    textColor: Color = sectionTextColorForTone(selected, tone),
    contentStart: ComposableFunction? = null,
    contentEnd: ComposableFunction? = null,
    contentTop: ComposableFunction? = null,
    contentBottom: ComposableFunction? = null,
    verticalPadding: Dp = 8.dp,
    onClick: UnitFunction? = null,
    onLongClick: UnitFunction? = null,
) {
    Section(
        first = first,
        last = last,
        onClick = onClick,
        onLongClick = onLongClick,
        selected = selected,
        tone = tone,
        modifier = modifier
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(
                top = verticalPadding, bottom = verticalPadding
            )
        ) {
            contentStart?.invoke()
            Column(
                modifier = Modifier
                    .padding(
                        start = 4.dp,
                        end = 10.dp
                    )
                    .weight(1f)
            ) {
                contentTop?.invoke()
                Text(
                    text = title,
                    style = MaterialTheme.typography.bodyLarge,
                    color = textColor,
                    textAlign = TextAlign.Start,
                    modifier = Modifier
                        .padding(bottom = 3.dp)
                )
                description?.let {
                    Text(
                        text = description,
                        style = MaterialTheme.typography.bodyMedium,
                        color = textColor,
                        textAlign = TextAlign.Start,
                    )
                }
                contentBottom?.invoke()
            }
            contentEnd?.invoke()
        }
    }
}