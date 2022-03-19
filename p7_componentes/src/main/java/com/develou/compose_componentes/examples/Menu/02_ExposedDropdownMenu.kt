package com.develou.compose_componentes.examples.Menu

import androidx.compose.foundation.layout.width
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun PhoneNumberTypeMenu() {
    val types = listOf("Fijo", "Móvil", "Trabajo", "Otro")
    val default = 0

    var expanded by remember { mutableStateOf(false) }
    var selectedType by remember { mutableStateOf(types[default]) }

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = {
            expanded = !expanded
        },
        modifier = Modifier.width(150.dp)
    ) {
        TextField(
            readOnly = true,
            value = selectedType,
            onValueChange = { },
            label = { Text("Tipo") },
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(
                    expanded = expanded
                )
            },
            colors = ExposedDropdownMenuDefaults.textFieldColors()
        )
        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = {
                expanded = false
            }
        ) {
            types.forEach { selectionOption ->
                DropdownMenuItem(
                    onClick = {
                        selectedType = selectionOption
                        expanded = false
                    }
                ) {
                    Text(text = selectionOption)
                }
            }
        }
    }
}