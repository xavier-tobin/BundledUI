package com.xaviertobin.bundledui.buttons

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.xaviertobin.bundledui.base.UnitFunction

@Composable
fun ButtonRow(
    modifier: Modifier = Modifier.Companion,
    paddingValues: PaddingValues = PaddingValues(
        end = 6.dp,
        bottom = 16.dp,
        top = 16.dp
    ),
    content: @Composable UnitFunction,
) {
    Row(
        verticalAlignment = Alignment.Companion.CenterVertically,
        horizontalArrangement = Arrangement.End,
        modifier = Modifier.Companion
            .then(modifier)
            .fillMaxWidth()
            .padding(paddingValues)
    ) {
        content()
    }
}