package com.develou.compose_componentes.examples.Button

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ButtonsScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.TopCenter
    ) {
        // Cambia este composable por el que deseas ejecutar
        ButtonToggleGroupExample()
    }
}

@Composable
@Preview
fun ButtonsScreenPreview() {
    MaterialTheme {
        Surface(
            modifier = Modifier
                .background(Color.White)
                .padding(16.dp)
        ) {
            ButtonsScreen()
        }
    }
}