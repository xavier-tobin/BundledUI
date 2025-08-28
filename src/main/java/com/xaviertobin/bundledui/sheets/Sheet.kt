package com.xaviertobin.bundledui.sheets

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.ime
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.statusBarsIgnoringVisibility
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.ModalBottomSheetProperties
import androidx.compose.material3.SheetValue
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalWindowInfo
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.xaviertobin.bundledui.section.widgets.SectionSwitch
import com.xaviertobin.bundledui.theme.BaseTheme
import com.xaviertobin.bundledui.theme.LocalBaseTheme
import com.xaviertobin.bundledui.theme.safeSurface

typealias UnitFunction = () -> Unit
typealias ComposableFunction = @Composable () -> Unit

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Sheet(
    onDismiss: UnitFunction,
    title: String? = null,
    plainTitle: String? = null,
    forceFullscreen: Boolean = false,
    userDismissible: Boolean = true,
    horizontalPadding: Dp = 22.dp,
    disableScroll: Boolean = false,
    defaultContentPadding: PaddingValues = PaddingValues(top = 6.dp, start = horizontalPadding, end = horizontalPadding),
    systemContentPadding: PaddingValues = WindowInsets.navigationBars.asPaddingValues(),
    content: @Composable (ColumnScope.() -> Unit),
) {

    val finalTitle = title ?: plainTitle


    SheetBase(
        onDismiss = onDismiss,
        forceFullscreen = forceFullscreen,
        userDismissible = userDismissible,
    ) { sheetState, isFullscreen ->

        if (userDismissible) {
            SheetDragHandleShield(sheetValue = sheetState, isFullscreen = isFullscreen)
        }

        if (finalTitle != null) {
            Text(
                text = finalTitle,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier
                    .padding(
                        top = 14.dp,
                        start = 40.dp,
                        bottom = 10.dp
                    )
            )
        }

        Box(
            modifier = Modifier.then(
                if (isFullscreen) Modifier.fillMaxSize() else Modifier
            )
        ) {

            Column(
                modifier = Modifier
                    .then(
                        if (!disableScroll) Modifier.verticalScroll(
                            rememberScrollState(),
                        ) else Modifier
                    )
                    .padding(systemContentPadding)
                    .padding(defaultContentPadding)

            ) {
                content()
            }


            if (finalTitle != null) {
                FadeScrollEdge()
            }
        }
    }

}


@Composable
fun FadeScrollEdge(height: Dp = 6.dp,  color: Color = MaterialTheme.colorScheme.safeSurface()) {
    Spacer(
        modifier = Modifier
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        color,
                        Color.Transparent
                    )
                )
            )
            .fillMaxWidth()
            .height(height)

    )
}

@OptIn(ExperimentalLayoutApi::class, ExperimentalMaterial3Api::class)
@Composable
fun SheetDragHandleShield(
    sheetValue: SheetValue,
    isFullscreen: Boolean
) {

    Column(
        modifier = Modifier
            .height(
                WindowInsets.statusBarsIgnoringVisibility
                    .asPaddingValues()
                    .calculateTopPadding()
            )
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        if (sheetValue != SheetValue.Expanded || !isFullscreen) {
            Spacer(
                modifier = Modifier
                    .background(
                        MaterialTheme.colorScheme.onSurfaceVariant.copy(
                            alpha = 0.3f
                        ),
                        RoundedCornerShape(6.dp)
                    )
                    .size(36.dp, 5.dp)
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun SheetBase(
    onDismiss: UnitFunction,
    properties: ModalBottomSheetProperties? = null,
    forceFullscreen: Boolean = false,
    contentWindowInsets: @Composable () -> WindowInsets = { WindowInsets.ime },
    userDismissible: Boolean = true,
    content: @Composable (ColumnScope.(targetState: SheetValue, isFullscreen: Boolean) -> Unit)
) {

    val modalSheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = true,
        confirmValueChange = { return@rememberModalBottomSheetState userDismissible || it == SheetValue.Expanded }
    )

    var isFullscreen by remember { mutableStateOf(forceFullscreen) }
    val isFullscreenExpanded = modalSheetState.targetValue == SheetValue.Expanded && isFullscreen

    val isLightTheme = LocalBaseTheme.current == BaseTheme.LIGHT
    val configuration = LocalWindowInfo.current
    val density = LocalDensity.current
    val top = WindowInsets.statusBars.getTop(density)

    val roundedCornerRadius by animateDpAsState(
        targetValue = if (isFullscreenExpanded) 4.dp else 36.dp,
        label = "roundedCornerRadius"
    )

    ModalBottomSheet(
        modifier = Modifier.onSizeChanged {
            isFullscreen =
                forceFullscreen || it.height >= (configuration.containerSize.height - top)
        },
        onDismissRequest = onDismiss,
        shape = RoundedCornerShape(roundedCornerRadius, roundedCornerRadius),
        sheetState = modalSheetState,
        sheetGesturesEnabled = userDismissible,
        dragHandle = null,
        contentWindowInsets = contentWindowInsets,
        containerColor = MaterialTheme.colorScheme.safeSurface(),
        contentColor = MaterialTheme.colorScheme.safeSurface(),
        tonalElevation = 0.dp,
        properties = properties ?: ModalBottomSheetProperties(
            isAppearanceLightNavigationBars = isLightTheme && !isFullscreenExpanded,
            isAppearanceLightStatusBars = isLightTheme && !isFullscreenExpanded
        ),
        content = {
            content(modalSheetState.targetValue, isFullscreen)
        }
    )
}

@Preview
@Composable
fun SheetPreview() {
    Sheet(title = "Theme settings", onDismiss = { /*TODO*/ }) {
        SectionSwitch(title = "Test toggle", checked = true, onChecked = {})
    }
}