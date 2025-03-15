package com.xaviertobin.bundledui.section.base

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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.xaviertobin.bundledui.base.Tone


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Section(
    modifier: Modifier = Modifier,
    first: Boolean = false,
    last: Boolean = false,
    orientation: SectionOrientation = SectionOrientation.VERTICAL,
    tone: Tone = Tone.NEUTRAL,
    focused: Boolean = false,
    selected: Boolean = false,
    margin: PaddingValues = SectionDefaults.marginValues(orientation, last),
    padding: PaddingValues = SectionDefaults.paddingValues(orientation, first, last),
    shape: RoundedCornerShape = SectionDefaults.shape(orientation, first, last),
    containerColor: Color = SectionDefaults.containerColor(selected, focused, tone),
    onClick: (() -> Unit)? = null,
    onLongClick: (() -> Unit)? = null,
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
            .padding(
                when (orientation) {
                    SectionOrientation.VERTICAL -> PaddingValues(vertical = extraInternalPadding)
                    SectionOrientation.HORIZONTAL -> PaddingValues(horizontal = extraInternalPadding)
                }
            )
    ) {
        content()
    }
}

