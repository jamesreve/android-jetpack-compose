package com.develou.compose_componentes.examples.Checkbox

import androidx.compose.material.Checkbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

@Composable
fun CheckboxExample() {
    val checked = remember { mutableStateOf(true) }
    Checkbox(
        checked = checked.value,
        onCheckedChange = { checked.value = it }
    )
}
