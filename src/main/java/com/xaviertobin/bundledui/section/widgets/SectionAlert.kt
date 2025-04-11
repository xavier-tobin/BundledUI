package com.xaviertobin.bundledui.section.widgets

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.xaviertobin.bundledui.base.Tone
import com.xaviertobin.bundledui.base.UnitFunction
import com.xaviertobin.bundledui.base.containerColorForTone
import com.xaviertobin.bundledui.base.iconColorForTone
import com.xaviertobin.bundledui.base.textColorForTone
import com.xaviertobin.bundledui.base.vividContainerColorForTone
import com.xaviertobin.bundledui.base.vividTextColorForTone
import com.xaviertobin.bundledui.buttons.ButtonRow
import com.xaviertobin.bundledui.buttons.RoundedButton
import com.xaviertobin.bundledui.section.base.Section


/**
 * A box that contains a title, icon and description of an issue, hint, warning, or prompt for the user.
 * Can include a dismiss button if the alert is not long-lived.
 * Description is mandatory, but other params are optional.
 **
 * In Bundled Notes, this is used around a hint system to explain functionality
 */
@Composable
fun SectionAlert(
    description: String,
    title: String? = null,
    icon: ImageVector? = null,
    tone: Tone = Tone.NEUTRAL,
    textColor: Color = textColorForTone(tone),
    containerColor: Color = containerColorForTone(tone),
    iconColor: Color = iconColorForTone(tone),
    buttonColor: Color = vividContainerColorForTone(tone),
    dismissOptions: DismissOptions? = null,
    first: Boolean = true,
    last: Boolean = true,
) {

    Section(
        first = first,
        last = last,
        containerColor = containerColor,
        modifier = Modifier.animateContentSize(
            animationSpec = spring(
                dampingRatio = Spring.DampingRatioLowBouncy,
                stiffness = Spring.StiffnessMedium
            )
        )
    ) {
        Row(
            modifier = Modifier
                .padding()
                .fillMaxWidth()
        ) {
            title?.let {

                Text(
                    text = it,
                    modifier = Modifier
                        .padding(
                            top = 10.dp,
                            end = 12.dp,
                        )
                        .weight(1f),
                    style = MaterialTheme.typography.bodyLarge.copy(fontSize = 16.5.sp),
                    textAlign = TextAlign.Start,
                    fontWeight = FontWeight.SemiBold,
                    color = textColor,
                )
            }

            icon?.let {
                Icon(
                    imageVector = it,
                    contentDescription = title ?: description,
                    modifier = Modifier.padding(
                        top = 8.dp,
                        end = 3.dp
                    ),
                    tint = iconColor
                )
            }
        }

        Text(
            text = description,
            modifier = Modifier
                .padding(
                    top = 12.dp,
                    bottom = 10.dp
                ),
            style = MaterialTheme.typography.bodyMedium.copy(fontSize = 14.5.sp),
            lineHeight = 20.sp,
            textAlign = TextAlign.Start,
            color = textColor,
        )

        dismissOptions?.let {
            ButtonRow(
                paddingValues = PaddingValues(
                    bottom = 6.dp
                )
            ) {
                RoundedButton(
                    onClick = it.onClick,
                    text = it.text,
                    containerColor = buttonColor,
                    textColor = vividTextColorForTone(tone)
                )
            }
        }
    }
}

data class DismissOptions(
    val text: String,
    val onClick: UnitFunction,
)