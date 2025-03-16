package com.xaviertobin.bundledui.sheets

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.ime
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsIgnoringVisibility
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.ModalBottomSheetProperties
import androidx.compose.material3.SheetValue
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.xaviertobin.bundledui.color.isLight
import com.xaviertobin.bundledui.section.widgets.SectionSwitch
import com.xaviertobin.bundledui.theme.safeSurface

typealias UnitFunction = () -> Unit
typealias ComposableFunction = @Composable () -> Unit

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Sheet(
    onDismiss: UnitFunction,
    title: String? = null,
    plainTitle: String? = null,
    fullscreen: Boolean = false,
    userDismissible: Boolean = true,
    usesKeyboard: Boolean = false,
    horizontalPadding: Dp = 22.dp,
    content: @Composable (ColumnScope.() -> Unit)
) {

    SheetBase(
        onDismiss = onDismiss,
        fullscreen = fullscreen,
        userDismissible = userDismissible
    ) {

        if (fullscreen) {
            SheetDragHandleShield(sheetValue = it)
        }

        Column(
            modifier = Modifier
                .then(
                    if (fullscreen) {
                        Modifier
                            .fillMaxSize()
                            .verticalScroll(rememberScrollState())
                            .padding(
                                top = 28.dp,
                                start = horizontalPadding,
                                end = horizontalPadding,
                                bottom = 22.dp
                            )
                    } else if (usesKeyboard) {
                        Modifier
                            .verticalScroll(rememberScrollState())
                            .padding(WindowInsets.navigationBars.asPaddingValues())
                            .padding(start = horizontalPadding, end = horizontalPadding)
                    } else {
                        Modifier
                            .padding(WindowInsets.navigationBars.asPaddingValues())
                            .padding(start = horizontalPadding, end = horizontalPadding)
                    }
                )
        ) {

            run { title ?: plainTitle }?.let {
                SheetTitle(it)
            }

            content()
        }
    }

}

@OptIn(ExperimentalLayoutApi::class, ExperimentalMaterial3Api::class)
@Composable
fun SheetDragHandleShield(
    sheetValue: SheetValue,
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
        if (sheetValue != SheetValue.Expanded) {
            Row(
                modifier = Modifier
                    .background(
                        MaterialTheme.colorScheme.onSurfaceVariant.copy(
                            alpha = 0.3f
                        ),
                        RoundedCornerShape(6.dp)
                    )
                    .size(36.dp, 5.dp)
            ) {}
        }
    }
}

@Composable
fun SheetTitle(title: String) {
    Text(
        title,
        color = MaterialTheme.colorScheme.onSurfaceVariant,
        style = MaterialTheme.typography.titleLarge,
        modifier = Modifier.padding(start = 20.dp, bottom = 20.dp)
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SheetBase(
    onDismiss: UnitFunction,
    properties: ModalBottomSheetProperties? = null,
    fullscreen: Boolean = false,
    contentWindowInsets: @Composable () -> WindowInsets = { WindowInsets.ime },
    userDismissible: Boolean = true,
    content: @Composable (ColumnScope.(targetState: SheetValue) -> Unit)
) {

    val modalSheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = true,
        confirmValueChange = { return@rememberModalBottomSheetState userDismissible || it == SheetValue.Expanded }
    )
    val expanded = modalSheetState.targetValue == SheetValue.Expanded
    val roundedCornerRadius by animateDpAsState(
        targetValue = if (expanded && fullscreen) 0.dp else 36.dp,
        label = "roundedCornerRadius"
    )

    val isLightTheme = MaterialTheme.colorScheme.surface.isLight()

    ModalBottomSheet(
        onDismissRequest = onDismiss,
        shape = RoundedCornerShape(roundedCornerRadius, roundedCornerRadius),
        sheetState = modalSheetState,
        sheetGesturesEnabled = userDismissible,
        dragHandle = {
            if (!fullscreen) {
                BottomSheetDefaults.DragHandle(
                    color = MaterialTheme.colorScheme.onSurfaceVariant.copy(
                        alpha = 0.3f
                    )
                )
            }
        },
        contentWindowInsets = contentWindowInsets,
        containerColor = MaterialTheme.colorScheme.safeSurface(),
        tonalElevation = 0.dp,
        properties = properties ?: ModalBottomSheetProperties(
            isAppearanceLightNavigationBars = isLightTheme,
            isAppearanceLightStatusBars = isLightTheme
        )
    ) {
        content(modalSheetState.targetValue)
    }
}

@Preview
@Composable
fun SheetPreview() {
    Sheet(title = "Theme settings", onDismiss = { /*TODO*/ }) {
        SectionSwitch(title = "Test toggle", checked = true, onChecked = {})
    }
}