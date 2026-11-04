package com.example.tallerconnect.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightColors = lightColorScheme(
    primary = Primary,
    onPrimary = Color.White,
    background = ScreenBackground,
    onBackground = TextDark,
    surface = Color.White,
    onSurface = TextDark,
    outline = BorderGray
)

@Composable
fun TallerConnectTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = LightColors,
        content = content
    )
}