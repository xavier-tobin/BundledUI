package com.xaviertobin.bundledui.section.widgets

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.xaviertobin.bundledui.base.ComposableFunction
import com.xaviertobin.bundledui.base.UnitFunction

@Composable
fun SectionSlider(
    text: String,
    value: Float,
    onValueChange: (Float) -> Unit,
    range: ClosedFloatingPointRange<Float>,
    steps: Int,
    modifier: Modifier = Modifier,
    onValueChangeFinished: UnitFunction? = null,
    valueDisplay: ComposableFunction? = null,
    description: String? = null,
    first: Boolean = false,
    last: Boolean = false,
) {

    SectionTitleDescription(
        first = first,
        last = last,
        title = text,
        description = description,
        modifier = modifier,
        contentBottom = {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Column(
                    modifier = Modifier
                        .padding(
                            top = 6.dp
                        )
                        .weight(1f)
                ) {

                    Slider(
                        value = value,
                        onValueChange = onValueChange,
                        onValueChangeFinished = onValueChangeFinished,
                        colors = SliderDefaults.colors(
                            thumbColor = MaterialTheme.colorScheme.tertiary,
                            activeTrackColor = MaterialTheme.colorScheme.tertiary,
                            inactiveTrackColor = MaterialTheme.colorScheme.tertiary.copy(0.2f),
                        ),
                        valueRange = range,
                        steps = steps,
                        modifier = Modifier.heightIn(40.dp)
                    )
                }
                valueDisplay?.invoke()
            }
        }
    )
}
