> IN PROGRESS - This library is not yet distributed and the docs are a work in progress.

# Bundled UI for Jetpack Compose

A simple, idiomatic Material 3 UI design system for Jetpack Compose,
built for
[Bundled Notes](https://play.google.com/store/apps/details?id=com.xaviertobin.noted).

## Quick look

<!-- ![Basic italics usage example](images/home_page.png) -->

<img src="images/all.png"  alt="Screenshots of the library being used in Bundled Notes"/>

## What's included?

BundledUI is the design system used in Bundled Notes. It includes a suite of easy-to-use UI
components and all the theming utilities required to create gorgeous Material You apps.

__This library is an abstraction around the Compose Material3 library. It will work with a
regular `MaterialTheme` wrapper, but to take advantage of the rich theming available (including
OLED & Dark themes), wrap your app in `BundledUITheme`:__

```kotlin
setContent {
    BundledUITheme(theme = BaseTheme.Dark) {
        // you can now use BundledUI
    }
}
```

> [!TIP]
> It can help to understand the basics of
> the [Compose Material3 library](https://developer.android.com/develop/ui/compose/designsystems/material3)

## `Section`

`Section` is a base, Card-like component that is found on almost every page of
Bundled Notes. It abstracts away almost all fiddling with padding, margin, and
modifiers, as well as supporting "Tone", orientation, clicks, enabled/selected states, and focus.

Though you can use the base `Section` directly, BundledUI includes a
number of `Section` components that are commonly used in Bundled Notes:

- `SectionTextInput` - A `Section` for entering text
- `SectionTitleDescription` - A `Section` card to display a basic list item
- `SectionButton` - Based on `SectionTitleDescription`, but clickable and with icon/loading support.
- `SectionButtonSheet` - A `SectionButton` that opens a `BottomSheet` when clicked.
- `SectionSwitch` - A `SectionTitleDescription` with a switch on the end.
- `SectionSlider` - A `Section` with a slider.
- `SectionAlert` - A `Section` designed to alert the user in varying tones.

All you have to do to get started is group related `Sections`, and set their
`first` and `last` params:

```kotlin
Column {

    SectionHeader("Theme")

    SectionButton(
        first = true,
        title = "Theme",
        description = "Choose between light, dark and OLED themes",
        icon = Icons.Rounded.WbSunny,
        onClick = { /* toggle between themes*/ }
    )

    SectionSwitch(
        title = "Enable Material You",
        description = "Tint theme based on wallpaper",
        checked = isChecked,
        onChecked = { isChecked = it }
    )

    SectionButtonSheet(
        last = true,
        title = "Font scale",
        description = "Choose fonts and text size",
        icon = Icons.Rounded.FontDownload,
    ) { onDismiss ->
        // FontSettingsSheet(onDismiss)
    }

}
```

The above code leads to this layout:

<img src="images/sections_basic.png" alt="Basic italics usage example" width="300" >

__In BundledUI, almost everything is a `Section` - you can make many layouts just by using
the include Section components and even creating your own.__

> [!NOTE]
> You don't have to think about padding and margins at all when
> using `Section`. The `first` and `last` parameters take care of all that for
> you.

# Theming

Theming in BundledUI is based on the standard `MaterialTheme`, but with a light wrapper to support:

- OLED themes
- Disabling/enabling Material You
- Custom Material You colors (beta)
- Status bar transparency
- Extensions to improve idiomatic colors

You can configure the theme using the `BundledUITheme` composable as mentioned above:

```kotlin

// get the current theme from your preferences, check if system is dark theme etc.
val currentTheme = getTheme()

setContent {
    BundledUITheme(
        theme = currentTheme,
        themeColors = CustomMaterialYouColors(primary = overrideColor),
        typography = { colorScheme ->
            // you can override typography here
        }
    ) {
        // you can now use BundledUI
    }
}

```

# Extras

> More to come... docs are a work in progress

