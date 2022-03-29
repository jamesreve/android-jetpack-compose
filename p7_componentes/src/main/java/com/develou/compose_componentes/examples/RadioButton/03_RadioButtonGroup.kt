package com.develou.compose_componentes.examples.RadioButton

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.develou.compose_componentes.examples.List.ListWithColumn

@Composable
fun RadioGroup(
    modifier: Modifier = Modifier,
    items: List<String>,
    selection: String,
    onItemClick: ((String) -> Unit)
) {
    Column(modifier = modifier) {
        items.forEach { item ->
            LabelledRadioButton(
                modifier = Modifier.fillMaxWidth(),
                label = item,
                selected = item == selection,
                onClick = {
                    onItemClick(item)
                }
            )
        }
    }
}

@Composable
fun Example3() {
    val animalTypes = listOf("Todos", "Perro", "Gato", "Aves")
    val currentSelection = remember { mutableStateOf(animalTypes.first()) }
    ListWithColumn(items = List(10) { "Item $it" })
    RadioGroup(
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