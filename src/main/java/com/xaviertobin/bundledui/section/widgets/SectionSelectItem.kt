package com.xaviertobin.bundledui.section.widgets


import androidx.compose.animation.animateContentSize
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.xaviertobin.bundledui.animations.AnimateInFade
import com.xaviertobin.bundledui.base.Tone
import com.xaviertobin.bundledui.base.UnitFunction
import com.xaviertobin.bundledui.base.rememberDpAsPx
import com.xaviertobin.bundledui.buttons.IconButton
import com.xaviertobin.bundledui.color.alpha
import com.xaviertobin.bundledui.section.base.Section
import com.xaviertobin.bundledui.section.extras.LoadingOrIcon


@Composable
fun <T> SectionSelectItem(
    title: String,
    selected: T? = null,
    onClear: UnitFunction,
    selectedItemView: @Composable (T) -> Unit,
    showSelectionPicker: @Composable (closeSelectionSheet: () -> Unit) -> Unit,
) {

    var shouldShowSelectionPicker by remember { mutableStateOf(false) }

    val strokeWidth = rememberDpAsPx(4.dp)

    val stroke = Stroke(
        width = strokeWidth,
        pathEffect = PathEffect.dashPathEffect(floatArrayOf(25f, 12f)),
    )

    val strokeColor = MaterialTheme.colorScheme.tertiary.alpha(0.5f)

    Row(
        modifier = Modifier
            .animateContentSize()
            .clip(
                RoundedCornerShape(34.dp)
            )
            .drawBehind {
                drawRoundRect(
                    color = strokeColor,
                    style = stroke,
                    cornerRadius = CornerRadius(34.dp.toPx())
                )
            },
        verticalAlignment = Alignment.CenterVertically
    ) {

        Box(
            modifier = Modifier
                .weight(1f)
                .padding(0.dp)
        ) {

            AnimateInFade(visible = selected == null) {
                SectionTitleDescription(
                    first = true,
                    last = true,
                    onClick = {
                        shouldShowSelectionPicker = true
                    },
                    title = title,
                    containerColor = Color.Transparent,
                    margin = PaddingValues(0.dp),
                    padding = PaddingValues(
                        top = 6.dp,
                        bottom = 6.dp,
                        start = 24.dp,
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
            }

            if (selected != null) {
                Section(
                    first = true,
                    last = true,
                    margin = PaddingValues(0.dp),
                    padding = PaddingValues(6.dp)
                ) {
                    selectedItemView(
                        selected
                    )
                }
            }
        }

        if (selected != null) {
            IconButton(
                icon = Icons.Rounded.Close,
                onClick = onClear,
                color = MaterialTheme.colorScheme.surface,
                backgroundColor = MaterialTheme.colorScheme.tertiary,
                contentDescription = "Deselect $title",
                padding = PaddingValues(4.dp),
                margin = PaddingValues(end = 18.dp, start = 10.dp),
                size = 20.dp
            )
        }
    }

    Spacer(Modifier.height(16.dp).fillMaxWidth())


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
