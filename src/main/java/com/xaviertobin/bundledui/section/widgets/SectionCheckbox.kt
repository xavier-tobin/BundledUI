package com.xaviertobin.bundledui.section.widgets

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.xaviertobin.bundledui.base.Tone
import com.xaviertobin.bundledui.section.base.SectionDefaults
import com.xaviertobin.bundledui.theme.ThemedPreview


@Composable
fun SectionCheckbox(
    title: String,
    description: String? = null,
    checked: Boolean,
    first: Boolean = false,
    last: Boolean = false,
    errorMessage: String? = null,
    enabled: Boolean = true,
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
        start = 16.dp,
    ),
    enabled = enabled,
    tone = if (errorMessage != null) {
        Tone.NEGATIVE
    } else {
        Tone.NEUTRAL
    },
    contentStart = {
        Checkbox(
            checked = checked,
            onCheckedChange = { onChecked(it) },
            colors = CheckboxDefaults.colors(
                checkedColor = MaterialTheme.colorScheme.tertiary,
                uncheckedColor = MaterialTheme.colorScheme.tertiary,
                checkmarkColor = MaterialTheme.colorScheme.surfaceColorAtElevation(12.dp)
            ),
            modifier = Modifier.padding(end = 4.dp)
        )
    },
    contentBottom = {
            SectionErrorMessage(
                errorMessage = errorMessage,
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
            description = "Click here",
            checked = toggledOn2,
            onChecked = { toggledOn2 = it },
            last = true
        )

    }
}