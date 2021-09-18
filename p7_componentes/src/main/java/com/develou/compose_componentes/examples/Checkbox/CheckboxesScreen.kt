package com.develou.compose_componentes.examples.Checkbox

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CheckboxesScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        // Reemplaza por el ejemplo que deseas ver
        DisabledCheckboxExample()
    }
}

@Composable
@Preview
fun CheckboxesScreenPreview() {
    MaterialTheme {
        Surface {
            CheckboxesScreen()
        }
    }
}