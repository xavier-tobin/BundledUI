package com.xaviertobin.bundledui.section.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.xaviertobin.bundledui.base.UnitFunction
import com.xaviertobin.bundledui.color.alpha
import com.xaviertobin.bundledui.section.base.Section
import com.xaviertobin.bundledui.section.base.SectionDefaults
import com.xaviertobin.bundledui.theme.text

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SectionSlider(
    text: String,
    value: Float,
    onValueChange: (Float) -> Unit,
    range: ClosedFloatingPointRange<Float>,
    steps: Int,
    modifier: Modifier = Modifier,
    onValueChangeFinished: UnitFunction? = null,
    first: Boolean = false,
    last: Boolean = false,
) {

    Section(
        first = first,
        last = last,
        modifier = modifier,
        padding = SectionDefaults.verticalPaddingValues(
            first = first,
            last = last,
            bottom = 6.dp,
            start = 26.dp
        ),
    ) {


        SectionTitle(
            title = text,
            textColor = MaterialTheme.colorScheme.text,
            padding = PaddingValues(vertical = 2.dp)
        )

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(top = 2.dp)
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
                modifier = Modifier
                    .weight(1f),
            )

            Box(modifier= Modifier.width( 70.dp), contentAlignment = Alignment.Center) {
                ValueBadge(
                    number = (if (value % 1  == 0f) value.toInt() else "%.2f".format(value)).toString(),
                    fontSize = 15.sp,
                    backgroundColor = MaterialTheme.colorScheme.tertiary,
                    color = MaterialTheme.colorScheme.surface,
                    margin = PaddingValues(start = 8.dp),
                    modifier = Modifier.fillMaxWidth()
                )

            }
        }

    }

}

@Composable
fun ValueBadge(
    number: String,
    color: Color = MaterialTheme.colorScheme.text,
    backgroundColor: Color = color.alpha(0.12f),
    margin: PaddingValues = PaddingValues(),
    fontSize: TextUnit = 12.5.sp,
    modifier: Modifier = Modifier,
) {


    Text(
        text = number,
        color = color,
        fontSize = fontSize,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .padding(margin)
            .background(
                color = backgroundColor,
                shape = CircleShape
            )
            .padding(horizontal = 8.dp, vertical = 4.dp)
            .then(modifier)

    )
}
