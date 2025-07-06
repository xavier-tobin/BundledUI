package com.xaviertobin.bundledui.buttons

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector


/**
 * SectionButtons are large clickable surfaces to designate significant actions, usually on a scrolling page or modal
 */
@Composable
fun IconButtonSheet(
    icon: ImageVector,
    contentDescription: String,
    modifier: Modifier = Modifier,
    tint: Color = MaterialTheme.colorScheme.primary,
    iconMargin: PaddingValues = IconButtonDefaults.margin,
    iconPadding: PaddingValues = IconButtonDefaults.padding,
    sheetLayout: @Composable (onDismiss: () -> Unit) -> Unit,
) {

    var showSheet by remember { mutableStateOf(false) }

    IconButton(
        contentDescription = contentDescription,
        icon = icon,
        modifier = modifier,
        tint = tint,
        margin = iconMargin,
        padding = iconPadding,
    ) {
        showSheet = true
    }

    if (showSheet) {
        sheetLayout { showSheet = false }
    }
}
