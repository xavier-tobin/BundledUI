>IN PROGRESS

# Bundled UI for Jetpack Compose

> A radically simple Material 3 UI design system, built
> for [Bundled Notes](https://play.google.com/store/apps/details?id=com.xaviertobin.noted).

## Why?

Material3 is a powerful suite of components for building beautiful Compose UIs, but many of the interactive components are [atom-level](http://atomicdesign.bradfrost.com/chapter-2/)
components that require wrapping and regular management of padding, margin and modifiers in order to
create a consistent, beautiful UI.

Bundled UI is a higher-level library, built on top of Material3, that 

### Benefits

- Lightweight abstraction, minimal dependencies
- Easy to use, hard to mis-use
- Almost no padding or margin management required

## Section

A Section is the building block of organisms in Bundled UI. It is a simple card with the following features:

* `onClick`/`onLongClick` support
* `Tone` support (i.e. positive, warning, negative, etc.)
* `focus` support (i.e. can be focused based on keyboard/mouse input)
* `disabled` support
* `selected` support (i.e can be toggled on/off)
* Automatic margin and padding management
* Orientation
* `first` and `last` parameters to manage grouping, spacing and border-radius of neighbouring sections

To build your UI, all you need to do is group related Sections, and correctly set the first and last
parameters.
