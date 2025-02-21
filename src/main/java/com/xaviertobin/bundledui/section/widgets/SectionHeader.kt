package com.xaviertobin.bundledui.section.widgets

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun SectionHeader(
        @StringRes header: Int,
) {
    SectionHeader(header = stringResource(id = header))
}

@Composable
fun SectionHeader(
       header: String,
) {
    Text(
        modifier = Modifier.padding(start = 26.dp, top = 10.dp, bottom = 6.dp),
        text = header,
        style = MaterialTheme.typography.labelLarge,
        color = MaterialTheme.colorScheme.primary,
        textAlign = TextAlign.Start,
    )
}