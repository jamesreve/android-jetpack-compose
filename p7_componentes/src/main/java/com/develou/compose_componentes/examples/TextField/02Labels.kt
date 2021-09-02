package com.develou.compose_componentes.examples.TextField

import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*

@Composable
fun LabelAndPlaceholderExample() {
    var address by remember {
        mutableStateOf("")
    }

    OutlinedTextField(
        value = address,
        onValueChange = { address = it },
        label = { Text("Dirección") },
        placeholder = { Text("¿Dónde vives?") }
    )
}