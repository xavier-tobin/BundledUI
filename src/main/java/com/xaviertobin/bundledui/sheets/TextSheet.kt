package com.xaviertobin.bundledui.sheets

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.unit.dp
import com.xaviertobin.bundledui.section.base.Section
import com.xaviertobin.bundledui.theme.secondaryText

/**
 * A sheet that displays annotated/styled text in a single Section, usually just for info etc.
 */
@Composable
fun TextSheet(
    onDismiss: UnitFunction,
    title: String,
    text: AnnotatedString,
    fullscreen: Boolean = false,
    extraContent: @Composable (() -> Unit)? = null
) {
    Sheet(onDismiss = onDismiss, title = title, forceFullscreen = fullscreen) {
        Section(first = true, last = true) {
            extraContent?.invoke()
            Text(
                modifier = Modifier.padding(vertical = 10.dp),
                text = text,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.secondaryText,
            )
        }
    }
}


/**
 * A sheet that displays plain text in a single Section, usually just for info etc.
 */
@Composable
fun TextSheet(
    onDismiss: UnitFunction,
    title: String,
    text: String,
    fullscreen: Boolean = false,
    extraContent: @Composable (() -> Unit)? = null
) = TextSheet(
    onDismiss = onDismiss,
    title = title,
    text = AnnotatedString(text),
    fullscreen = fullscreen,
    extraContent = extraContent
)

