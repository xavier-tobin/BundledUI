package com.xaviertobin.bundledui.buttons

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.xaviertobin.bundledui.base.ToggleComposable
import com.xaviertobin.bundledui.base.Tone
import com.xaviertobin.bundledui.base.UnitFunction
import com.xaviertobin.bundledui.base.vividContainerColorForTone
import com.xaviertobin.bundledui.base.vividTextColorForTone
import com.xaviertobin.bundledui.color.alpha
import com.xaviertobin.bundledui.section.extras.EndIcon
import com.xaviertobin.bundledui.section.extras.LoadingOrIcon

val RoundedButtonPadding = PaddingValues(
    start = 18.dp,
    top = 8.dp,
    bottom = 8.dp,
    end = 18.dp
)

@Composable
fun RoundedButton(
    text: String,
    modifier: Modifier = Modifier,
    tone: Tone = Tone.NEUTRAL,
    containerColor: Color = vividContainerColorForTone(tone),
    textColor: Color = vividTextColorForTone(tone),
    enabled: Boolean = true,
    contentPadding: PaddingValues = RoundedButtonPadding,
    endContent: (@Composable () -> Unit)? = null,
    onClick: UnitFunction,
) {
    Button(
        onClick = { onClick() },
        colors = ButtonDefaults.buttonColors(
            containerColor = containerColor,
            disabledContainerColor = containerColor
        ),
        modifier = Modifier
            .alpha(if (enabled) 1f else 0.7f)
            .then(modifier),
        contentPadding = contentPadding,
        enabled = enabled
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.bodyLarge,
            color = textColor,
            textAlign = TextAlign.End,
        )
        endContent?.invoke()
    }
}

// TODO move to app, StringRes version
@Composable
fun RoundedButton(
    @StringRes text: Int,
    modifier: Modifier = Modifier,
    tone: Tone = Tone.NEUTRAL,
    containerColor: Color = vividContainerColorForTone(tone),
    textColor: Color = vividTextColorForTone(tone),
    enabled: Boolean = true,
    contentPadding: PaddingValues = RoundedButtonPadding,
    endContent: (@Composable () -> Unit)? = null,
    onClick: UnitFunction,
) = RoundedButton(
    text = stringResource(id = text),
    modifier = modifier,
    tone = tone,
    containerColor = containerColor,
    textColor = textColor,
    enabled = enabled,
    contentPadding = contentPadding,
    endContent = endContent,
    onClick = onClick
)

@Composable
fun RoundedLoadingButton(
    text: String,
    loadingText: String,
    modifier: Modifier = Modifier,
    tone: Tone = Tone.POSITIVE,
    containerColor: Color = vividContainerColorForTone(tone),
    textColor: Color = vividTextColorForTone(tone),
    icon: ImageVector? = null,
    loading: Boolean = false,
    onClick: UnitFunction,
) = RoundedButton(
        text = if (loading) loadingText else text,
        modifier = modifier,
        tone = tone,
        containerColor = containerColor,
        onClick = onClick,
        enabled = !loading,
        textColor = textColor,
        endContent = {
            LoadingOrIcon(
                loadingFromClick = loading,
                tint = textColor,
                icon = icon,
                iconDescription = text,
                tone = tone
            )
        }
    )


@Composable
fun RoundedButton(
    text: String,
    modifier: Modifier = Modifier,
    tone: Tone = Tone.POSITIVE,
    enabled: Boolean = true,
    containerColor: Color = vividContainerColorForTone(tone),
    textColor: Color = vividTextColorForTone(tone),
    contentPadding: PaddingValues = RoundedButtonPadding,
    icon: ImageVector,
    onClick: UnitFunction,
) = RoundedButton(
    text = text,
    modifier = modifier,
    tone = tone,
    containerColor = containerColor,
    contentPadding = contentPadding,
    onClick = onClick,
    enabled = enabled,
    textColor = textColor,
    endContent = {
        EndIcon(
            icon = icon,
            tint = textColor,
            iconDescription = text
        )
    }
)

@Composable
fun RoundedButtonSheet(
    @StringRes text: Int,
    modifier: Modifier = Modifier,
    tone: Tone = Tone.NEUTRAL,
    endContent: (() -> Unit)? = null,
    containerColor: Color = vividContainerColorForTone(tone),
    textColor: Color = vividTextColorForTone(tone),
    contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
    sheetLayout: @Composable (onDismiss: () -> Unit) -> Unit
) {
    ToggleComposable(
        defaultContent = { onShow ->
            RoundedButton(
                text = text,
                modifier = modifier,
                tone = tone,
                endContent = endContent,
                containerColor = containerColor,
                textColor = textColor,
                contentPadding = contentPadding
            ) {
                onShow()
            }
        },
        enabledContent = { onDismiss ->
            sheetLayout.invoke(onDismiss)
        }
    )
}

@Composable
fun RoundedButtonSheet(
    text: String,
    modifier: Modifier = Modifier,
    tone: Tone = Tone.NEUTRAL,
    icon: ImageVector,
    containerColor: Color = vividContainerColorForTone(tone),
    textColor: Color = vividTextColorForTone(tone),
    contentPadding: PaddingValues = RoundedButtonPadding,
    sheetLayout: @Composable (onDismiss: () -> Unit) -> Unit
) {
    ToggleComposable(
        defaultContent = { onShow ->
            RoundedButton(
                text = text,
                modifier = modifier,
                tone = tone,
                icon = icon,
                containerColor = containerColor,
                textColor = textColor,
                contentPadding = contentPadding
            ) {
                onShow()
            }
        },
        enabledContent = sheetLayout
    )
}

@Preview
@Composable
private fun RoundedButtonPreview() {
    var loading by remember { mutableStateOf(false) }
    Column {
        ButtonRow {
            RoundedLoadingButton(
                text = "Update email",
                loadingText = "Updating email",
                loading = loading,
                tone = Tone.POSITIVE
            ) {
                loading = true
            }
            RoundedButton(
                text = "Cancel",
                tone = Tone.NEUTRAL,
                icon = Icons.Rounded.Email
            ) { }
        }

        ButtonRow {
            RoundedLoadingButton(
                text = "Share info",
                loadingText = "Sharing info",
                loading = true,
            ) {
                loading = true
            }
        }
    }
}

