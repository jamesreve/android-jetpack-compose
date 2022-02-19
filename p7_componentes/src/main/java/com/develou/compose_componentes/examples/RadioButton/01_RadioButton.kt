package com.develou.compose_componentes.examples.RadioButton

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.RadioButton
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun DevelouRadioButton() {
    var isSelected by remember { mutableStateOf(false) }

    RadioButton(
        selected = isSelected,
        onClick = { isSelected = true }
    )
}

@Composable
fun Example1() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        contentAlignment = Alignment.Center
    ) {
        DevelouRadioButton()
    }
}