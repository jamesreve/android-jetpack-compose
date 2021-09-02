package com.develou.compose_componentes.examples.TextField

import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*

@Composable
fun TextFieldExample() {
    var name by remember {
        mutableStateOf("Carlos")
    }

    TextField(
        value = name,
        onValueChange = { name = it },
        label = { Text("Nombre") }
    )
}

@Composable
fun OutlinedTextFieldExample() {
    var name by remember {
        mutableStateOf("Carlos")
    }

    OutlinedTextField(
        value = name,
        onValueChange = { name = it },
        label = { Text("Nombre") }
    )
}