package com.xaviertobin.bundledui.animations

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun AnimatedVerticalVisibility(
    visible: Boolean,
    modifier: Modifier = Modifier,
    clipRadius: Dp = 28.dp,
    content: @Composable (AnimatedVisibilityScope.() -> Unit)
) = AnimatedVisibility(
    visible = visible,
    enter = fadeIn(tween(350))
            + expandVertically(defaultSpring),
    exit = shrinkVertically(defaultSpring)
            + fadeOut(tween(350)),
    modifier = Modifier
        .then(modifier)
        .clip(RoundedCornerShape(clipRadius)),
    content = content
)