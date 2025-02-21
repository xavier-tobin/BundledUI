package com.xaviertobin.bundledui.section.widgets


import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.xaviertobin.bundledui.section.base.Tone
import com.xaviertobin.bundledui.section.base.UnitFunction
import com.xaviertobin.bundledui.section.base.iconColorForTone
import com.xaviertobin.bundledui.section.section.sectionTextColorForTone


@Composable
fun LoadingOrIcon(
    loadingFromClick: Boolean,
    icon: ImageVector,
    tone: Tone,
    iconDescription: String
) {
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
            contentDescription = iconDescription,
            tint = iconColorForTone(tone)
        )
    }
}

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
    description = description.toString(),
    onLongClick = onLongClick,
    tone = tone,
    textColor = textColor,
    contentEnd = {
        LoadingOrIcon(
            loadingFromClick = loadingFromClick,
            icon = icon,
            tone = tone,
            iconDescription = title
        )
    }
)
