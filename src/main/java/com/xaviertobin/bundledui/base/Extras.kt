package com.xaviertobin.bundledui.base

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

typealias UnitFunction = () -> Unit
typealias ComposableFunction = @Composable () -> Unit

fun Modifier.conditional(
    predicate: Boolean,
    block: Modifier.() -> Modifier
): Modifier {
    return if (predicate) block(this) else this
}

@Composable
fun rememberDpAsPx(scrollThreshold: Dp = 150.dp): Float {
    return with(LocalDensity.current) { scrollThreshold.toPx() }
}
