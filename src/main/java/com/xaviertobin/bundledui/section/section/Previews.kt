package com.xaviertobin.bundledui.section.section

import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Stars
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.xaviertobin.bundledui.section.base.Tone
import com.xaviertobin.bundledui.section.widgets.SectionButton


@Preview
@Composable
fun SectionButtonPreview() {
    Column {
        // normally
        SectionButton(
            first = true,
            text = "Button that does something",
            description = "Description for button that does something",
            icon = Icons.Rounded.Stars,
            loadingFromClick = true
        ) {}

        SectionButton(
            text = "Another button that does something",
            description = "Description for another button that does something",
            icon = Icons.Rounded.Stars,
            tone = Tone.POSITIVE
        ) {}

        SectionButton(
            text = "Another button that does something",
            description = "Description for another button that does something",
            icon = Icons.Rounded.Stars,
            selected = true
        ) {}

        SectionButton(
            last = true,
            text = "Another button that does something",
            description = "Description for another button that does something",
            icon = Icons.Rounded.Stars
        ) {}

    }
}