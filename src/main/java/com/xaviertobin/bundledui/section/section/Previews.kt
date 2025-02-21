package com.xaviertobin.bundledui.section.section

import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Stars
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.xaviertobin.bundledui.section.base.Tone
import com.xaviertobin.bundledui.section.widgets.SectionHeader
import com.xaviertobin.bundledui.section.widgets.SectionTextDescription
import com.xaviertobin.bundledui.section.widgets.SectionTextDescriptionIcon


@Preview
@Composable
fun SectionButtonPreview() {
    Column {
        // normally
        SectionTextDescriptionIcon(
            first = true,
            text = "Button that does something",
            description = "Description for button that does something",
            icon = Icons.Rounded.Stars,
            loadingFromClick = true
        ) {}

        Section(
            text = "Another button that does something",
            description = "Description for another button that does something",
            icon = Icons.Rounded.Stars,
        ) {}

        SectionButton(
            text = "Another button that does something",
            description = "Description for another button that does something",
            icon = Icons.Rounded.Stars,
            selected = true
        ) {}

        SectionHeader("Buttons with different tones")
        SectionButton(
            first = true,
            last = true,
            text = "Warning",
            description = "Warning",
            icon = Icons.Rounded.Stars,
            tone = Tone.WARNING
        ) {}

    }
}