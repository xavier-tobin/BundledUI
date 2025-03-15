package com.xaviertobin.bundledui.section.base

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.xaviertobin.bundledui.base.Tone
import com.xaviertobin.bundledui.base.containerColorForTone
import com.xaviertobin.bundledui.base.firstLastCornersHorizontal
import com.xaviertobin.bundledui.base.firstLastCornersVertical
import com.xaviertobin.bundledui.base.iconColorForTone
import com.xaviertobin.bundledui.base.textColorForTone

object SectionDefaults {

    /**
     * PADDING
     */

    fun paddingValues(
        orientation: SectionOrientation,
        first: Boolean,
        last: Boolean
    ): PaddingValues {
        return when (orientation) {
            SectionOrientation.VERTICAL -> verticalPaddingValues(first, last)
            SectionOrientation.HORIZONTAL -> horizontalPaddingValues(first, last)
        }
    }

    fun verticalPaddingValues(
        first: Boolean = false,
        last: Boolean = false,
    ) = PaddingValues(
        top = if (first) 10.dp else 8.dp,
        bottom = if (last) 10.dp else 8.dp,
        start = 22.dp,
        end = 22.dp
    )

    fun horizontalPaddingValues(
        first: Boolean = false,
        last: Boolean = false,
    ) = PaddingValues(
        start = if (first) 24.dp else 20.dp,
        end = if (last) 24.dp else 20.dp,
        top = 12.dp,
        bottom = 12.dp,
    )

    /**
     * MARGIN
     */

    fun marginValues(orientation: SectionOrientation, last: Boolean): PaddingValues {
        return when (orientation) {
            SectionOrientation.VERTICAL -> verticalMarginValues(last)
            SectionOrientation.HORIZONTAL -> horizontalMarginValues()
        }
    }

    fun verticalMarginValues(
        last: Boolean = false,
    ) = PaddingValues(
        bottom = if (last) 16.dp else 2.dp,
        top = 2.dp
    )

    fun horizontalMarginValues() = PaddingValues(
        end = 5.dp,
        start = 0.dp,
    )

    /**
     * COLOR
     */

    @Composable
    fun containerColor(selected: Boolean, focused: Boolean, tone: Tone): Color {
        return if (selected) {
            MaterialTheme.colorScheme.tertiary
        } else if (focused) {
            MaterialTheme.colorScheme.surfaceContainerHigh
        } else {
            containerColorForTone(tone)
        }
    }

    @Composable
    fun iconColor(
        tone: Tone,
        selected: Boolean
    ): Color {
        return if (selected) {
            MaterialTheme.colorScheme.surface
        } else {
            iconColorForTone(tone)
        }
    }

    /**
     * CORNERS
     */

    fun shape(orientation: SectionOrientation, first: Boolean, last: Boolean): RoundedCornerShape {
        return when (orientation) {
            SectionOrientation.VERTICAL -> firstLastCornersVertical(first, last)
            SectionOrientation.HORIZONTAL -> firstLastCornersHorizontal(first, last)
        }
    }

}

enum class SectionOrientation {
    VERTICAL,
    HORIZONTAL
}


@Composable
fun sectionTextColorForTone(selected: Boolean, tone: Tone): Color {
    return if (selected) {
        MaterialTheme.colorScheme.surface
    } else {
        textColorForTone(tone)
    }
}
