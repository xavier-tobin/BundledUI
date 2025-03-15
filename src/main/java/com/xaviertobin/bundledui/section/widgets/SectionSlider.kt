package com.xaviertobin.bundledui.section.widgets

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.xaviertobin.bundledui.base.ComposableFunction
import com.xaviertobin.bundledui.base.UnitFunction
import com.xaviertobin.bundledui.section.base.Section


/**
 * SectionButtons are large clickable surfaces to designate significant actions, usually on a scrolling page or modal
 */
@Composable
fun SectionSlider(
    text: String,
    value: Float,
    onValueChange: (Float) -> Unit,
    range: ClosedFloatingPointRange<Float>,
    steps: Int,
    onValueChangeFinished: UnitFunction? = null,
    modifier: Modifier = Modifier,
    valueDisplay: ComposableFunction? = null,
    description: String? = null,
    first: Boolean = false,
    last: Boolean = false,
) {

    Section(
        first = first,
        last = last,
        modifier = modifier,
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            textAlign = TextAlign.Start,
            modifier = Modifier
                .padding(bottom = 4.dp, start = 4.dp)

        )
        description?.let {
            Text(
                text = description,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                textAlign = TextAlign.Start,
                modifier = Modifier.padding(start = 4.dp)
            )
        }

        Row {
            Column(
                modifier = Modifier
                    .padding(
                        end = 10.dp,
                        top = 4.dp
                    ).weight(1f)
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
                )
            }
            valueDisplay?.invoke()
        }
    }
}
