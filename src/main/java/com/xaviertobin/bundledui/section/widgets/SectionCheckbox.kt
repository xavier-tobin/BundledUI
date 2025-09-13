package com.xaviertobin.bundledui.section.widgets

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.xaviertobin.bundledui.base.Tone
import com.xaviertobin.bundledui.base.maybeClickable
import com.xaviertobin.bundledui.section.base.SectionDefaults
import com.xaviertobin.bundledui.theme.ThemedPreview


@Composable
fun SectionCheckbox(
    title: String,
    description: String? = null,
    checked: Boolean,
    first: Boolean = false,
    last: Boolean = false,
    errorMessage: String? = null,
    enabled: Boolean = true,
    onChecked: (Boolean) -> Unit,
) = SectionTitleDescription(
    first = first,
    last = last,
    onClick = { onChecked(!checked) },
    title = title,
    description = description,
    padding = SectionDefaults.verticalPaddingValues(
        first = first,
        last = last,
        start = 16.dp,
    ),
    enabled = enabled,
    tone = if (errorMessage != null) {
        Tone.NEGATIVE
    } else {
        Tone.NEUTRAL
    },
    contentStart = {
        EntryCheckbox(
            checked = checked,
            onCheckedChange = { onChecked(it) },
            margin = PaddingValues(start = 8.dp, end = 16.dp)
        )
    },
    contentBottom = {
            SectionErrorMessage(
                errorMessage = errorMessage,
            )

    }
)



@Composable
fun EntryCheckbox(
    enabled: Boolean = true,
    checked: Boolean,
    margin: PaddingValues = PaddingValues(horizontal = 8.dp),
    onCheckedChange: (Boolean) -> Unit,
    accent: Color = MaterialTheme.colorScheme.tertiary,
    background: Color = MaterialTheme.colorScheme.surface,
    onBackground: Color = MaterialTheme.colorScheme.surfaceColorAtElevation(12.dp),
) {

    val vibration = LocalHapticFeedback.current

    val backgroundColor by animateColorAsState(
        targetValue = if (checked) accent else Color.Transparent,
        label = "Checkbox color animation"
    )

    val checkColor by animateColorAsState(
        targetValue = if (checked) background else onBackground,
        label = "Checkbox color animation"
    )

    val size by animateDpAsState(
        targetValue = if (checked) 18.dp else 2.dp,
        label = "Checkbox size animation"
    )

    val alpha by animateFloatAsState(
        targetValue = if (checked) 1f else 0.0f,
        label = "Checkbox alpha animation"
    )

    val rotate by animateFloatAsState(
        targetValue = if (checked) 0f else -180f,
        label = "Checkbox rotate animation",
        animationSpec = spring(
            dampingRatio = 0.5f
        )
    )

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .padding(margin)
            .size(23.dp)
            .clip(
                shape = CircleShape
            )
            .rotate(
                degrees = rotate
            )
            .maybeClickable(
                enabled = enabled
            ) {
                vibration.performHapticFeedback(HapticFeedbackType.ToggleOn )
                onCheckedChange(!checked)
            }
            .background(
                color = backgroundColor,
            )
            .border(
                width = 2.2.dp,
                color = accent,
                shape = CircleShape
            )
            .alpha(
                alpha = if (enabled) 1f else 0.7f
            ),
    ) {
        Icon(
            imageVector = Icons.Rounded.Check,
            contentDescription = "Toggle checkbox",
            tint = checkColor,
            modifier = Modifier
                .size(size)
                .alpha(alpha = alpha)
        )
    }
}

@Preview
@Composable
fun SectionCheckboxPreview() {
    var toggledOn1 by remember { mutableStateOf(false) }
    var toggledOn2 by remember { mutableStateOf(false) }

    ThemedPreview {
        SectionCheckbox(
            title = "Enable feature",
            checked = toggledOn1,
            onChecked = { toggledOn1 = it },
            first = true
        )

        SectionCheckbox(
            title = "Enable a different feature",
            description = "Click here",
            checked = toggledOn2,
            onChecked = { toggledOn2 = it },
            last = true
        )

    }
}