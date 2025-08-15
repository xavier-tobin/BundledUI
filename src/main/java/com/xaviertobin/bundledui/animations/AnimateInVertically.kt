package com.xaviertobin.bundledui.animations

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.VisibilityThreshold
import androidx.compose.animation.core.spring
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp

@Composable
fun AnimateInVertically(
    clipRadius: Dp = 28.dp,
    modifier: Modifier = Modifier.clip(RoundedCornerShape(clipRadius)),
    visible: Boolean = true,
    content: @Composable (AnimatedVisibilityScope.() -> Unit)
) = AnimatedVisibility(
    visible = visible,
    enter = fadeIn() + expandVertically(),
    exit = shrinkVertically() + fadeOut(),
    content = content,
    modifier = modifier
)

@Composable
fun AnimatedVerticalVisibility(
    modifier: Modifier = Modifier,
    clipRadius: Dp = 28.dp,
    visible: Boolean = true,
    content: @Composable (AnimatedVisibilityScope.() -> Unit)
) = AnimatedVisibility(
    visible = visible,
    enter = fadeIn() + expandVertically(
        animationSpec = spring(
            stiffness = Spring.StiffnessMediumLow,
            dampingRatio = 0.7f,
            visibilityThreshold = IntSize.VisibilityThreshold
        )
    ),
    exit = fadeOut() + shrinkVertically(
        animationSpec = spring(
            stiffness = Spring.StiffnessMediumLow,
            dampingRatio = 1f,
            visibilityThreshold = IntSize.VisibilityThreshold
        )
    ),
    modifier = Modifier
        .clip(RoundedCornerShape(clipRadius))
        .then(modifier),
    content = content
)