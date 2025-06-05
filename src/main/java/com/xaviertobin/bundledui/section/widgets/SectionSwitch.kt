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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.xaviertobin.bundledui.section.base.SectionDefaults


@Composable
fun SectionSwitch(
    title: String,
    description: String? = null,
    checked: Boolean,
    first: Boolean = false,
    last: Boolean = false,
    onChecked: (Boolean) -> Unit,
) = SectionTitleDescription(
    first = first,
    last = last,
    onClick = { onChecked(!checked) },
    title = title,
    description = description,
    padding = SectionDefaults.verticalPaddingValues(
        first = first,
        last = last,
        bottom = 3.dp,
        top = 3.dp
    ),
    contentEnd = {
        Switch(
            checked = checked,
            onCheckedChange = { onChecked(it) },
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
        SectionSwitch(
            title = "Enable feature",
            checked = toggledOn1,
            onChecked = { toggledOn1 = it },
            first = true
        )

        SectionSwitch(
            title = "Enable a different feature",
            description = "This is a description",
            checked = toggledOn2,
            onChecked = { toggledOn2 = it },
            last = true
        )

    }
}