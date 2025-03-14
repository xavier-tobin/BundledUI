package com.xaviertobin.bundledui.section.section

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.xaviertobin.bundledui.base.Tone
import com.xaviertobin.bundledui.base.containerColorForTone
import com.xaviertobin.bundledui.base.firstLastCornersVertical
import com.xaviertobin.bundledui.base.textColorForTone


fun defaultVerticalSectionMarginValues(
    last: Boolean = false,
) = PaddingValues(bottom = if (last) 16.dp else 2.dp, top = 2.dp)

fun defaultVerticalSectionPaddingValues(
    first: Boolean = false,
    last: Boolean = false,
) = PaddingValues(
    top = if (first) 10.dp else 8.dp,
    bottom = if (last) 10.dp else 8.dp,
    start = 22.dp,
    end = 22.dp
)

@Composable
fun sectionContainerColorForTone(selected: Boolean, focused: Boolean, tone: Tone): Color {
    return if (selected) {
        MaterialTheme.colorScheme.tertiary
    } else if (focused) {
        MaterialTheme.colorScheme.surfaceContainerHigh
    } else {
        containerColorForTone(tone)
    }
}

@Composable
fun sectionTextColorForTone(selected: Boolean, tone: Tone): Color {
    return if (selected) {
        MaterialTheme.colorScheme.surface
    } else {
        textColorForTone(tone)
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Section(
    modifier: Modifier = Modifier,
    first: Boolean = false,
    last: Boolean = false,
    orientation: SectionOrientation = SectionOrientation.VERTICAL,
    focused: Boolean = false,
    selected: Boolean = false,
    margin: PaddingValues = defaultVerticalSectionMarginValues(last),
    padding: PaddingValues = defaultVerticalSectionPaddingValues(first, last),
    tone: Tone = Tone.NEUTRAL,
    containerColor: Color = sectionContainerColorForTone(selected, focused, tone),
    onClick: (() -> Unit)? = null,
    onLongClick: (() -> Unit)? = null,
    defaultCornerRadius: Dp = 9.dp,
    pronouncedCornerRadius: Dp = 30.dp,
    shape: RoundedCornerShape = firstLastCornersVertical(
        first, last, defaultCornerRadius, pronouncedCornerRadius
    ),
    content: @Composable ColumnScope.() -> Unit,
) {

    val extraInternalPadding by animateDpAsState(
        if (selected) 8.dp else 0.dp, label = "extraInternalPadding"
    )

    Column(
        modifier = Modifier
            .clip(shape)
            .padding(margin)
            .clip(shape)
            .combinedClickable(
                enabled = onClick != null || onLongClick != null,
                onClick = { onClick?.invoke() },
                onLongClick = { onLongClick?.invoke() }
            )
            .focusable(onClick != null)
            .background(containerColor)
            .clip(shape)
            .then(modifier)
            .padding(padding)
            .padding(vertical = extraInternalPadding)
    ) {
        content()
    }
}

enum class SectionOrientation {
    VERTICAL,
    HORIZONTAL
}