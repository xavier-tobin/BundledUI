package com.xaviertobin.bundledui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Stars
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.xaviertobin.bundledui.base.Tone
import com.xaviertobin.bundledui.color.randomAestheticColor
import com.xaviertobin.bundledui.section.widgets.SectionButton
import com.xaviertobin.bundledui.section.widgets.SectionHeader



@Composable
fun ThemedPreview(
    theme: BaseThemeSetting = BaseThemeSetting.LIGHT,
    content: @Composable () -> Unit,
) {
    BundledUITheme(
        themeSetting = theme,
        themeColors = CustomMaterialYouColors(primary = Color.randomAestheticColor())
    ) {
        Column(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.surface)
                .padding(8.dp)
        ) {
            content()
        }
    }
}

@Composable
private fun SectionGroupPreview(baseThemeSetting: BaseThemeSetting) {
    ThemedPreview(
        theme = baseThemeSetting
    ) {
        // normally
        SectionButton(
            first = true,
            title = "Button that does something",
            description = "Description for button that does something",
            icon = Icons.Rounded.Stars,
            loadingFromClick = true
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
            title = "Warning",
            description = "Warning",
            icon = Icons.Rounded.Stars,
            tone = Tone.WARNING
        ) {}

        SectionButton(
            last = true,
            title = "Error",
            description = "Error",
            icon = Icons.Rounded.Stars,
            tone = Tone.NEGATIVE
        ) {}

    }
}

@Preview
@Composable
fun SettingsPreviewLight()  = SectionGroupPreview(BaseThemeSetting.LIGHT)

@Preview
@Composable
fun SettingsPreviewDark()  = SectionGroupPreview(BaseThemeSetting.DARK)

@Preview
@Composable
fun SettingsPreviewOLED()  = SectionGroupPreview(BaseThemeSetting.OLED)