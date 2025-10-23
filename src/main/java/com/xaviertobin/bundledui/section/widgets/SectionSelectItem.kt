package com.xaviertobin.bundledui.section.widgets


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.xaviertobin.bundledui.base.UnitFunction
import com.xaviertobin.bundledui.base.rememberDpAsPx
import com.xaviertobin.bundledui.buttons.IconButton
import com.xaviertobin.bundledui.color.alpha


@Composable
fun <T> SectionSelectItem(
    title: String,
    selected: T?,
    onClear: UnitFunction,
    selectedItemView: @Composable (T) -> Unit,
    selectionList: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
) {

    val strokeWidth = rememberDpAsPx(1.8.dp)

    val stroke = Stroke(
        width = strokeWidth,
        pathEffect = PathEffect.dashPathEffect(floatArrayOf(24f, 12f)),
    )

    val strokeColor = MaterialTheme.colorScheme.tertiary.alpha(0.5f)

    val shape = RoundedCornerShape(34.dp)

    Row(
        modifier = Modifier
            .then(modifier)
            .background(
                color = MaterialTheme.colorScheme.tertiary.alpha(0.06f),
                shape = shape
            )
            .drawBehind {
                drawRoundRect(
                    color = strokeColor,
                    style = stroke,
                    cornerRadius = CornerRadius(34.dp.toPx())
                )
            }
            .padding(1.dp)

            .clip(shape),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Box(modifier = Modifier.weight(1f)) {
            if (selected == null) {
                selectionList()
            } else {
                selectedItemView(
                    selected
                )
            }
        }

        if (selected != null && enabled) {
            IconButton(
                icon = Icons.Rounded.Close,
                onClick = onClear,
                color = MaterialTheme.colorScheme.surface,
                backgroundColor = MaterialTheme.colorScheme.tertiary,
                contentDescription = "Deselect $title",
                padding = PaddingValues(2.dp),
                margin = PaddingValues(end = 18.dp, start = 10.dp),
                size = 18.dp
            )
        }

    }

    Spacer(
        Modifier
            .height(16.dp)
            .fillMaxWidth()
    )
}


@Preview
@Composable
fun SectionSelectItemPreview() {
    Column {

//        SectionSelectItem(
//            title = "Title",
//            description = "Description",
//            icon = Icons.Rounded.Check,
//            selected = true,
//            tone = Tone.NEUTRAL,
//            onClick = {}
//        )

    }
}
