package com.develou.compose_componentes.examples.RadioButton

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp

@Composable
fun RadioGroupWithSelectable(
    modifier: Modifier,
    items: List<String>,
    selection: String,
    onItemClick: ((String) -> Unit)
) {
    Column(modifier = modifier.selectableGroup()) {
        items.forEach { item ->
            LabelledRadioButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .selectable(
                        selected = item == selection,
                        onClick = { onItemClick(item) },
                        role = Role.RadioButton
                    ),
                label = item,
                selected = item == selection,
                onClick = null
            )
        }
    }
}

@Composable
fun Example4() {
    val animalTypes = listOf("Todos", "Perro", "Gato", "Aves")
    val currentSelection = remember { mutableStateOf(animalTypes.first()) }

    RadioGroupWithSelectable(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        items = animalTypes,
        selection = currentSelection.value,
        onItemClick = { clickedItem ->
            currentSelection.value = clickedItem
        }
    )
}