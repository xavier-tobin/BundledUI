> IN PROGRESS - This library is not yet distributed and the docs are a work in progress.

# Bundled UI for Jetpack Compose

A simple, idiomatic Material 3 UI design system for Jetpack Compose,
built for
[Bundled Notes](https://play.google.com/store/apps/details?id=com.xaviertobin.noted).

## Quick look

<!-- ![Basic italics usage example](images/home_page.png) -->

<img src="images/all.png"  alt="Screenshots of the library being used in Bundled Notes"/>

## What's included?

BundledUI is the design system used in Bundled Notes. It includes a whole suite
of easy-to-use UI components, and color/theming utilities that were required to build the app in Jetpack
Compose.

__This library is an abstraction around the Compose Material3 library, so you will need to wrap your
Compose layout in a MaterialTheme to get started:__

```kotlin
setContent {
    MaterialTheme {
        // you can now use BundledUI
    }
}
```

> [!NOTE]
> This library makes building UIs very easy, but it helps to
> understand
> the [Compose Material3 library](https://developer.android.com/develop/ui/compose/designsystems/material3).
> You can use the default MaterialTheme, but BundledUI includes utilities to make custom Material
> themes (_as seen in Bundled Notes_).

## `Section`

`Section` is a base, Card-like component that is found on almost every page of
Bundled Notes. It abstracts away almost all fiddling with padding, margin, and
modifiers, as well as supporting "Tone", orientation, clicks, enabled/selected states, and focus.

Though you can use the base `Section` directly (and make your own `Section` widgets), BundledUI includes a
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

    SectionSwitch(
        first = true,
        text = "Enable Material You",
        description = "Tint the theme ",
        checked = isChecked,
        onChecked = { isChecked = it }
    )

    SectionButton(
        text = R.string.theme,
        description = R.string.change_theme_settings,
        icon = Icons.Rounded.WbSunny,
        onClick = { /* toggle between themes*/ }
    )

    SectionButtonSheet(
        title = "Font options",
        description = "Choose fonts and text size",
        icon = Icons.Rounded.FontDownload,
        last = true,
    ) { onDismiss ->
        FontSettingsSheet(onDismiss = onDismiss)
    }

}
```

The above code leads to this layout:

<img src="images/sections_basic.png" alt="Basic italics usage example" width="300" >

> [!NOTE]
> Note that you don't have to think about padding and margins at all when
> using `Section`. The `first` and `last` parameters take care of all that for
> you.

# More to come... docs are a work in progress