package com.xaviertobin.bundledui.sheets

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp

@Composable
fun TakeoverSheet(
    onDismiss: UnitFunction,
    content: @Composable ColumnScope.() -> Unit,
) {

    BackHandler {
        // lazy way to stop back press from closing sheet
    }

    Sheet(
        onDismiss = onDismiss,
        fullscreen = true,
        userDismissible = false,
        horizontalPadding = 0.dp,
    ) {
        content.invoke(this)
    }
}
