package com.xaviertobin.bundledui.buttons

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ButtonRow(
    modifier: Modifier = Modifier,
    paddingValues: PaddingValues = PaddingValues(
        end = 6.dp,
        bottom = 16.dp,
        top = 16.dp
    ),
    content: @Composable RowScope.() -> Unit,
) {

    FlowRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.End),
        verticalArrangement = Arrangement.spacedBy(12.dp, Alignment.CenterVertically),
        modifier = Modifier.Companion
            .then(modifier)
            .fillMaxWidth()
            .padding(paddingValues)
    ) {
        content()
    }
}