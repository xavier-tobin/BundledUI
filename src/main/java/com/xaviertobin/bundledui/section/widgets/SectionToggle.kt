package com.xaviertobin.bundledui.section.widgets

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun SectionToggle(
    text: String,
    description: String? = null,
    toggledOn: Boolean,
    first: Boolean = false,
    last: Boolean = false,
    onToggled: (Boolean) -> Unit,
) = SectionTitleDescription(
        first = first,
        last = last,
        onClick = { onToggled(!toggledOn) },
        title = text.capitalize(Locale.current),
        description = description,
        verticalPadding = 4.dp,
        contentEnd = {
            Switch(
                checked = toggledOn,
                onCheckedChange = { onToggled(it) },
                colors = SwitchDefaults.colors(
                    uncheckedTrackColor = Color.Transparent,
                    checkedTrackColor = MaterialTheme.colorScheme.tertiary,
                    checkedThumbColor = MaterialTheme.colorScheme.surfaceColorAtElevation(12.dp)
                ),
                modifier = Modifier.padding(end = 4.dp),
            )
        }
    )

@Preview
@Composable
fun SwitchesPreview() {
    var toggledOn1 by remember { mutableStateOf(false) }
    var toggledOn2 by remember { mutableStateOf(false) }

    Column {
        SectionToggle(
            text = "Enable feature",
            toggledOn = toggledOn1,
            onToggled = { toggledOn1 = it },
            first = true
        )

        SectionToggle(
            text = "Enable a different feature",
            toggledOn = toggledOn2,
            onToggled = { toggledOn2 = it },
            last = true
        )

    }
}