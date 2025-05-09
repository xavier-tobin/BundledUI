package com.xaviertobin.bundledui.animations

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.VisibilityThreshold
import androidx.compose.animation.core.spring
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkHorizontally
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp

@Composable
fun AnimateInHorizontally(
    modifier: Modifier = Modifier.clip(RoundedCornerShape(28.dp)),
    visible: Boolean = true,
    content: @Composable (AnimatedVisibilityScope.() -> Unit)
) = AnimatedVisibility(
    visible = visible,
    enter = fadeIn() + expandHorizontally(
        animationSpec = spring(
            stiffness = Spring.StiffnessLow,
            visibilityThreshold = IntSize.VisibilityThreshold
        )
    ) { -it },
    exit = shrinkHorizontally(
        animationSpec = spring(
            stiffness = Spring.StiffnessLow,
            visibilityThreshold = IntSize.VisibilityThreshold
        )
    ) { -it } + fadeOut(),
    modifier = modifier,
    content = content)