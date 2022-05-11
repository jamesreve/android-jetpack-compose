package com.develou.compose_componentes.examples.TopAppBar


import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
internal fun TopAppBarCustomBackground() {
    DetailTopAppBar(backgroundColor = Color(0xFF2196F3))
}

@Composable
internal fun TopAppBarCustomContentColor() {
    DetailTopAppBar(contentColor = Color(0xFFFFEB3B))
}

@Composable
internal fun TopAppBarCustomElevation() {
    DetailTopAppBar(elevation = 8.dp, backgroundColor = Color.White)
}