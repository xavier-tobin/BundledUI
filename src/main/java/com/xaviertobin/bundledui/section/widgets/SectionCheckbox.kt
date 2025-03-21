package com.xaviertobin.bundledui.section.widgets

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
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
import com.xaviertobin.bundledui.theme.ThemedPreview


@Composable
fun SectionCheckbox(
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
    title = title.capitalize(Locale.current),
    description = description,
    verticalPadding = 4.dp,
    contentStart = {
        Checkbox(
            checked = checked,
            onCheckedChange = { onChecked(it) },
            colors = CheckboxDefaults.colors(

                checkedColor = MaterialTheme.colorScheme.tertiary,
                uncheckedColor = MaterialTheme.colorScheme.tertiary,
                checkmarkColor = MaterialTheme.colorScheme.surfaceColorAtElevation(12.dp)
            ),
            modifier = Modifier.padding(end = 4.dp),

            )
    }
)

@Preview
@Composable
fun SectionCheckboxPreview() {
    var toggledOn1 by remember { mutableStateOf(false) }
    var toggledOn2 by remember { mutableStateOf(false) }

    ThemedPreview {
        SectionCheckbox(
            title = "Enable feature",
            checked = toggledOn1,
            onChecked = { toggledOn1 = it },
            first = true
        )

        SectionCheckbox(
            title = "Enable a different feature",
            checked = toggledOn2,
            onChecked = { toggledOn2 = it },
            last = true
        )

    }
}