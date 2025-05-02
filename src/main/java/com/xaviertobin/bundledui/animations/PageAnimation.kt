package com.xaviertobin.bundledui.animations

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.ContentTransform
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.togetherWith

/**
 * Can be used in AnimatedContent to animate the transition between two pages.
 * AnimatedContent(transitionSpec = { pageAnimation() }, ...)
 */
fun <S> AnimatedContentTransitionScope<S>.pageAnimation(): ContentTransform {
    return (fadeIn(tween(300)) + slideInVertically(animationSpec = spring()) { it / 2 })
        .togetherWith(slideOutVertically(animationSpec = spring()) { it / 2 } + fadeOut(
            tween(200)
        )).apply {
            targetContentZIndex = 10f
        }
}