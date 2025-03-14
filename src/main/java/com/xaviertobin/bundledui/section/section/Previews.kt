package com.xaviertobin.bundledui.section.section

import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Stars
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.xaviertobin.bundledui.base.Tone
import com.xaviertobin.bundledui.section.widgets.SectionButton
import com.xaviertobin.bundledui.section.widgets.SectionHeader


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