package com.xaviertobin.bundledui.section.widgets

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.xaviertobin.bundledui.base.ComposableFunction
import com.xaviertobin.bundledui.base.Tone
import com.xaviertobin.bundledui.base.UnitFunction
import com.xaviertobin.bundledui.color.alpha
import com.xaviertobin.bundledui.section.base.Section
import com.xaviertobin.bundledui.section.base.SectionDefaults
import com.xaviertobin.bundledui.section.base.sectionTextColorForTone
import com.xaviertobin.bundledui.section.extras.EndIcon


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
    enabled: Boolean = true,
    icon: ImageVector,
) = SectionTitleDescription(
    title = title,
    description = description,
    first = first,
    last = last,
    selected = selected,
    tone = tone,
    textColor = textColor,
    enabled = enabled,
    contentEnd = {
        EndIcon(
            icon = icon,
            iconDescription = title,
            color = textColor
        )
    },
    modifier = modifier,
)


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
    padding: PaddingValues = SectionDefaults.verticalPaddingValues(
        first = first,
        last = last,
        top = 16.dp,
        bottom = 16.dp
    ),
    enabled: Boolean = true,
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
        modifier = modifier,
        enabled = enabled,
        padding = padding
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
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
                    fontWeight = FontWeight.Medium,
                    color = textColor,
                    textAlign = TextAlign.Start,
                    modifier = Modifier
                        .padding(bottom = 1.dp)
                )
                description?.let {
                    Text(
                        text = description,
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.Normal,
                        color = textColor.alpha(0.9f),
                        textAlign = TextAlign.Start,
                    )
                }
                contentBottom?.invoke()
            }
            contentEnd?.invoke()
        }
    }
}