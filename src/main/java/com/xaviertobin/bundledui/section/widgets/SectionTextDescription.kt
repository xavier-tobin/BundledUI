package com.xaviertobin.bundledui.section.widgets

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.xaviertobin.bundledui.section.base.Tone
import com.xaviertobin.bundledui.section.section.Section
import com.xaviertobin.bundledui.section.base.UnitFunction
import com.xaviertobin.bundledui.section.base.iconColorForTone
import com.xaviertobin.bundledui.section.section.sectionTextColorForTone


@Composable
fun SectionTextDescriptionIcon(
    modifier: Modifier = Modifier,
    @StringRes text: Int,
    @StringRes description: Int? = null,
    first: Boolean = false,
    last: Boolean = false,
    selected: Boolean = false,
    tone: Tone = Tone.NEUTRAL,
    textColor: Color = sectionTextColorForTone(selected, tone),
    icon: ImageVector,
    verticalPadding: Dp = 8.dp,
    loadingFromClick: Boolean = false,
    onClick: UnitFunction? = null,
    onLongClick: UnitFunction? = null,
) {

    val textString = stringResource(text)

    SectionTextDescription(
        text = textString,
        description = description?.let { AnnotatedString(stringResource(description)) },
        first = first,
        last = last,
        selected = selected,
        tone = tone,
        textColor =  textColor,
        contentEnd = {
            if (loadingFromClick) {
                CircularProgressIndicator(
                    modifier = Modifier
                        .padding(end = 6.dp)
                        .size(24.dp)
                )
            } else {
                Icon(
                    modifier = Modifier.padding(end = 6.dp),
                    imageVector = icon,
                    contentDescription = textString,
                    tint = iconColorForTone(tone)
                )
            }
        },
        modifier = modifier,
        verticalPadding = verticalPadding,
        onClick = onClick,
        onLongClick = onLongClick
    )
}


@Composable
fun SectionTextDescriptionIcon(
    text: String,
    modifier: Modifier = Modifier,
    description: AnnotatedString? = null,
    first: Boolean = false,
    last: Boolean = false,
    selected: Boolean = false,
    tone: Tone = Tone.NEUTRAL,
    textColor: Color = sectionTextColorForTone(selected, tone),
    icon: ImageVector,
    verticalPadding: Dp = 8.dp,
    loadingFromClick: Boolean = false,
    onClick: UnitFunction? = null,
    onLongClick: UnitFunction? = null,
) {
    SectionTextDescription(
        text = text,
        description = description,
        first = first,
        last = last,
        selected = selected,
        tone = tone,
        textColor = textColor,
        contentEnd = {
            if (loadingFromClick) {
                CircularProgressIndicator(
                    modifier = Modifier
                        .padding(end = 6.dp)
                        .size(24.dp)
                )
            } else {
                Icon(
                    modifier = Modifier.padding(end = 6.dp),
                    imageVector = icon,
                    contentDescription = text,
                    tint = iconColorForTone(tone)
                )
            }
        },
        modifier = modifier,
        verticalPadding = verticalPadding,
        onClick = if (loadingFromClick) null else onClick,
        onLongClick = if (loadingFromClick) null else onLongClick
    )
}


@Composable
fun SectionTextDescription(
    text: String,
    modifier: Modifier = Modifier,
    description: AnnotatedString? = null,
    first: Boolean = false,
    last: Boolean = false,
    selected: Boolean = false,
    tone: Tone = Tone.NEUTRAL,
    textColor: Color = sectionTextColorForTone(selected, tone),
    contentEnd: @Composable () -> Unit,
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
            Column(
                modifier = Modifier
                    .padding(
                        start = 4.dp,
                        end = 10.dp
                    )
                    .weight(1f)
            ) {
                Text(
                    text = text,
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
            }
            contentEnd()
        }
    }
}