package com.xaviertobin.bundledui.section.base

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.FontDownload
import androidx.compose.material.icons.rounded.Stars
import androidx.compose.material.icons.rounded.WbSunny
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.xaviertobin.bundledui.base.Tone
import com.xaviertobin.bundledui.color.deintensify
import com.xaviertobin.bundledui.color.randomAestheticColor
import com.xaviertobin.bundledui.section.widgets.SectionButton
import com.xaviertobin.bundledui.section.widgets.SectionButtonSheet
import com.xaviertobin.bundledui.section.widgets.SectionHeader
import com.xaviertobin.bundledui.section.widgets.SectionSwitch
import com.xaviertobin.bundledui.theme.BaseTheme
import com.xaviertobin.bundledui.theme.BundledUITheme


@Composable
private fun BundledUIPreview(
    content: @Composable () -> Unit
) {
    BundledUITheme(theme = BaseTheme.LIGHT, overrideColor = Color.randomAestheticColor()) {
        Column(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.surface)
                .padding(8.dp)
        ) {
            content()
        }
    }
}

@Preview
@Composable
fun SectionButtonPreview() {
    Column {
        // normally
        SectionButton(
            first = true,
            title = "Button that does something",
            description = "Description for button that does something",
            icon = Icons.Rounded.Stars,
            loadingFromClick = true
        ) {}

        SectionButton(
            title = "Another button that does something",
            description = "Description for another button that does something",
            icon = Icons.Rounded.Stars,
        ) {}

        SectionButton(
            last = true,
            title = "Another button that does something",
            description = "Description for another button that does something",
            icon = Icons.Rounded.Stars,
            selected = true
        ) {}

        SectionHeader("Buttons with different tones")
        SectionButton(
            first = true,
            last = true,
            title = "Warning",
            description = "Warning",
            icon = Icons.Rounded.Stars,
            tone = Tone.WARNING
        ) {}

    }
}

@Preview
@Composable
fun SettingsPreview() {

    var isChecked by remember { mutableStateOf(true) }

    BundledUIPreview {

        SectionHeader("Theme")

        SectionButton(
            first = true,
            title = "Theme",
            description = "Choose between light, dark and OLED themes",
            icon = Icons.Rounded.WbSunny,
            onClick = { /* toggle between themes*/ }
        )

        SectionSwitch(
            title = "Enable Material You",
            description = "Tint theme based on wallpaper",
            checked = isChecked,
            onChecked = { isChecked = it }
        )

        SectionButtonSheet(
            last = true,
            title = "Font scale",
            description = "Choose fonts and text size",
            icon = Icons.Rounded.FontDownload,
        ) { onDismiss ->
            // FontSettingsSheet(onDismiss)
        }

    }
}