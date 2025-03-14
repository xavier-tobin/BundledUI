package com.xaviertobin.bundledui.base

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue


@Composable
fun ToggleComposable(
    defaultContent: @Composable (onShow: UnitFunction) -> Unit,
    enabledContent: @Composable (onDismiss: UnitFunction) -> Unit
) {
    var showEnabledContent by remember { mutableStateOf(false) }
    defaultContent { showEnabledContent = true }
    if (showEnabledContent) {
        enabledContent { showEnabledContent = false }
    }
}