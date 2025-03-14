package com.xaviertobin.bundledui.animations

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun AnimateInSlideDown(
    modifier: Modifier = Modifier,
    visible: Boolean = true,
    content: @Composable (AnimatedVisibilityScope.() -> Unit)
) = AnimatedVisibility(
    visible = visible,
    enter = slideInVertically(animationSpec = tween(150)) { -it } + fadeIn(),
    exit = slideOutVertically(animationSpec = tween(150)) { -it } + fadeOut(),
    content = content,
    modifier = modifier
)


