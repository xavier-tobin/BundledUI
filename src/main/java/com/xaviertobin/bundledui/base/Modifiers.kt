package com.xaviertobin.bundledui.base

import androidx.compose.foundation.clickable
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.disabled
import androidx.compose.ui.semantics.semantics

fun Modifier.maybeClickable(
    enabled: Boolean,
    onClick: () -> Unit
) = this.then(
    if (enabled) {
        Modifier.clickable(
            onClick = onClick,
        )
    } else {
        Modifier
    }
)
    .semantics {
        if (!enabled) disabled()
    }