package com.develou.compose_temas.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.ExperimentalUnitApi

private val LightColors = lightColors(
    primary = Blue500,
    primaryVariant = Blue700,
    secondary = Yellow500
)

private val DarkColors = darkColors(
    primary = Blue200,
    primaryVariant = Blue700,
    secondary = Yellow500
)

@ExperimentalUnitApi
@Composable
fun ProductsTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colors = if (darkTheme) DarkColors else LightColors,
        typography = ProductsTypography,
        shapes = ProductsShapes,
        content = content
    )
}