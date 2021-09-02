package com.develou.compose_componentes.examples.TextField

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp

@Composable
fun KeyboardOptionsExample() {
    var category by remember {
        mutableStateOf("")
    }

    TextField(
        value = category,
        onValueChange = { category = it },
        label = { Text("Nombre de categoría") },
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Send
        )
    )
}

@ExperimentalComposeUiApi
@Composable
fun KeyboardActionsExample() {
    var category by remember {
        mutableStateOf("")
    }

    var categories by remember {
        mutableStateOf("Categorías:\n")
    }

    val keyboardController = LocalSoftwareKeyboardController.current

    Column {

        TextField(
            value = category,
            onValueChange = { category = it },
            label = { Text("Nombre de categoría") },
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Send
            ),
            keyboardActions = KeyboardActions(onSend = {
                keyboardController?.hide()
                categories += "- $category\n"
            })
        )
        Spacer(Modifier.size(16.dp))
        Text(categories)
    }
}