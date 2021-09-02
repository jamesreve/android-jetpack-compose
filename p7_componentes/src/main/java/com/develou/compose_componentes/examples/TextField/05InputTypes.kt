package com.develou.compose_componentes.examples.TextField

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SingleLineExample() {
    var description by remember {
        mutableStateOf("Campo de texto")
    }

    TextField(
        value = description,
        onValueChange = { description = it },
        label = { Text("Descripción") },
        singleLine = true,
        modifier = Modifier.width(200.dp)
    )
}

@Composable
fun MultiLineExample() {
    var description by remember {
        mutableStateOf("Campo de texto")
    }

    TextField(
        value = description,
        onValueChange = { description = it },
        label = { Text("Descripción") },
        maxLines = 3,
        modifier = Modifier.width(200.dp)
    )
}

@Composable
fun TextAreaExample() {
    var description by remember {
        mutableStateOf("Área de texto con una altura fija de 150dp")
    }

    TextField(
        value = description,
        onValueChange = { description = it },
        label = { Text("Descripción") },
        modifier = Modifier
            .width(200.dp)
            .height(100.dp)
    )
}


@Composable
fun ReadOnlyExample() {
    OutlinedTextField(
        value = "INV-0001",
        onValueChange = { },
        label = { Text("Número de factura") },
        readOnly = true
    )
}