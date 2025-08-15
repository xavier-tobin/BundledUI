package com.xaviertobin.bundledui.section.base

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.xaviertobin.bundledui.base.Tone
import com.xaviertobin.bundledui.base.containerColorForTone
import com.xaviertobin.bundledui.base.firstLastCornersHorizontal
import com.xaviertobin.bundledui.base.firstLastCornersVertical
import com.xaviertobin.bundledui.base.iconColorForTone
import com.xaviertobin.bundledui.base.textColorForTone
import com.xaviertobin.bundledui.color.blend

object SectionDefaults {

    /**
     * PADDING
     */

    fun paddingValues(
        orientation: SectionOrientation,
        first: Boolean,
        last: Boolean,
    ): PaddingValues {
        return when (orientation) {
            SectionOrientation.VERTICAL -> verticalPaddingValues(first, last)
            SectionOrientation.HORIZONTAL -> horizontalPaddingValues(first, last)
        }
    }

    fun verticalPaddingValues(
        first: Boolean = false,
        last: Boolean = false,
        top: Dp = 8.dp,
        bottom: Dp = 8.dp,
        start: Dp = 22.dp,
        end: Dp = 22.dp,
        firstLastExtra: Dp = 2.dp,
    ) = PaddingValues(
        start = start,
        end = end,
        top = if (first) top + firstLastExtra else top,
        bottom = if (last) bottom + firstLastExtra else bottom,
    )

    fun horizontalPaddingValues(
        first: Boolean = false,
        last: Boolean = false,
        firstLastExtra: Dp = 4.dp,
        top: Dp = 12.dp,
        bottom: Dp = 12.dp,
        start: Dp = 20.dp,
        end: Dp = 20.dp
    ) = PaddingValues(
        start = if (first) start + firstLastExtra else start,
        end = if (last) end + firstLastExtra else end,
        top = top,
        bottom = bottom,
    )

    /**
     * MARGIN
     */

    @Composable
    fun marginValues(orientation: SectionOrientation, last: Boolean): PaddingValues {
        return when (orientation) {
            SectionOrientation.VERTICAL -> verticalMarginValues(last)
            SectionOrientation.HORIZONTAL -> horizontalMarginValues()
        }
    }

    @Composable
    fun verticalMarginValues(
        last: Boolean = false,
    ): PaddingValues {
        val result by animateDpAsState(if (last) 16.dp else 2.dp, label = "verticalMarginValues")
        return PaddingValues(
            bottom = result,
            top = 2.dp
        )
    }

    fun horizontalMarginValues() = PaddingValues(
        end = 5.dp,
        start = 0.dp,
    )

    /**
     * COLOR
     */

    @Composable
    fun containerColor(toggled: Boolean, focused: Boolean, tone: Tone): Color {

        val animatedColor by animateColorAsState(
            targetValue = if (toggled) {
                MaterialTheme.colorScheme.tertiary
            } else if (focused) {
                MaterialTheme.colorScheme.surface.blend(
                    MaterialTheme.colorScheme.tertiary,
                    by = 0.2f
                )
            } else {
                containerColorForTone(tone)
            },
            animationSpec = tween(durationMillis = 200),
            label = "sectionColor"
        )

        return animatedColor
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

    @Composable
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

    val animatedColor by animateColorAsState(
        targetValue = if (selected) {
            MaterialTheme.colorScheme.surface
        } else {
            textColorForTone(tone)
        },
        animationSpec = tween(durationMillis = 200)
    )

    return animatedColor

}
