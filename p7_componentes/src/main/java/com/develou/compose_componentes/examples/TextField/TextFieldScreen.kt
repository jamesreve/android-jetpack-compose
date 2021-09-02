package com.develou.compose_componentes.examples.TextField

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun TextFieldScreen() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        // Cambia este composable por el que deseas ejecutar
        SuffixExample()
    }
}

@Preview("Ejemplos De TextField")
@Composable
fun TextFieldExamples() {
    MaterialTheme {
        Surface(modifier = Modifier.padding(16.dp)) {
            TextFieldScreen()
        }
    }
}