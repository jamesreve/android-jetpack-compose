package com.develou.compose_estado.examples

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@Composable
fun OperandTextField(
    label: String,
    number: String,
    numberChange: (String) -> Unit
) {
    TextField(
        value = number,
        onValueChange = numberChange,
        label = { Text(label) },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
    )
}

@Composable
fun Spacer() {
    androidx.compose.foundation.layout.Spacer(modifier = Modifier.size(16.dp))
}