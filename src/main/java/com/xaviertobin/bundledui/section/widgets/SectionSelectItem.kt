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
import androidx.compose.material.icons.automirrored.rounded.OpenInNew
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.xaviertobin.bundledui.animations.AnimatedHorizontalVisibility
import com.xaviertobin.bundledui.base.Tone
import com.xaviertobin.bundledui.base.UnitFunction
import com.xaviertobin.bundledui.base.rememberDpAsPx
import com.xaviertobin.bundledui.buttons.IconButton
import com.xaviertobin.bundledui.color.alpha
import com.xaviertobin.bundledui.section.base.Section
import com.xaviertobin.bundledui.section.extras.LoadingOrIcon
import com.xaviertobin.bundledui.theme.elevatedSurface


@Composable
fun <T> SectionSelectItem(
    title: String,
    selected: T? = null,
    onClear: UnitFunction,
    selectedItemView: @Composable (T) -> Unit,
    showSelectionPicker: @Composable (closeSelectionSheet: () -> Unit) -> Unit,
    enabled: Boolean = true,
) {

    var shouldShowSelectionPicker by remember { mutableStateOf(false) }

    val strokeWidth = rememberDpAsPx(4.dp)

    val stroke = Stroke(
        width = strokeWidth,
        pathEffect = PathEffect.dashPathEffect(floatArrayOf(30f, 12f)),
    )

    val strokeColor = MaterialTheme.colorScheme.tertiary.alpha(0.5f)

    val shape = RoundedCornerShape(34.dp)

    Row(
        modifier = Modifier
            .clip(shape)
            .background(
                MaterialTheme.colorScheme.elevatedSurface().alpha(0.4f)
            )
            .drawBehind {
                if (selected == null) {
                    drawRoundRect(
                        color = strokeColor,
                        style = stroke,
                        cornerRadius = CornerRadius(34.dp.toPx())
                    )
                }
            },
        verticalAlignment = Alignment.CenterVertically
    ) {

        Box(
            modifier = Modifier
                .weight(1f)
                .padding(0.dp)
        ) {

            if (selected == null) {
                SectionTitleDescription(
                    first = true,
                    last = true,
                    onClick = {
                        shouldShowSelectionPicker = true
                    },
                    title = title,
                    containerColor = MaterialTheme.colorScheme.elevatedSurface().alpha(0.4f),
                    margin = PaddingValues(0.dp),
                    padding = PaddingValues(
                        top = 5.5.dp,
                        bottom = 5.5.dp,
                        start = 28.dp,
                        end = 16.dp
                    ),
                    contentEnd = {
                        LoadingOrIcon(
                            icon = Icons.AutoMirrored.Rounded.OpenInNew,
                            iconDescription = title,
                            loadingFromClick = false,
                            tone = Tone.NEUTRAL
                        )
                    }
                )
            } else {
                Section(
                    first = true,
                    last = true,
                    margin = PaddingValues(0.dp),
                    padding = PaddingValues(4.dp)
                ) {
                    selectedItemView(
                        selected
                    )
                }
            }
        }

        AnimatedHorizontalVisibility(selected != null && enabled) {
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

    Spacer(Modifier
        .height(16.dp)
        .fillMaxWidth())


    if (shouldShowSelectionPicker) {
        showSelectionPicker {
            shouldShowSelectionPicker = false
        }
    }
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
