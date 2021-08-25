package com.develou.compose_estado.examples

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun TextFieldWithoutState() {
    TextField(
        value = "",
        onValueChange = { },
        label = { Text("Número 1") }
    )
}

@Composable
fun TextFieldWithState() {
    var firstNumber by remember { mutableStateOf("") }
    TextField(
        value = firstNumber,
        onValueChange = { firstNumber = it },
        label = { Text("Número 1") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
    )
}