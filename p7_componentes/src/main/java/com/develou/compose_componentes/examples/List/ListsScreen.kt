package com.develou.compose_componentes.examples.List

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.develou.compose_componentes.examples.Example
import com.develou.compose_componentes.examples.RadioButton.SurfaceForPreview

@Composable
fun ListsScreen() {
    val examples = listOf(
        Example("Ej. 1") { Components() },
        Example("Ej. 2") { Properties() },
        Example("Ej. 3") { Gestures() },
        Example("Ej. 4") { Controls() },
        Example("Ej. 5") { Theming() }
    )
    var state by remember { mutableStateOf(0) }

    Column(modifier = Modifier.fillMaxSize()) {
        TabRow(selectedTabIndex = state) {
            examples.forEachIndexed { index, example ->
                Tab(
                    text = { Text(example.title) },
                    selected = state == index,
                    onClick = { state = index }
                )

            }
        }

        examples[state].content()
    }
}

@Composable
private fun Components() {
    ListComponentComparison()
}

@Composable
private fun Properties() {
    val options = listOf(
        Example("2.1 Cambiar Padding Del Contenido") { ListWithContentPadding() },
        Example("2.2 Cambiar Espaciado Del Contenido") { ListWithContentSpacing() },
        Example("2.3 Añadir Divisores") { ListWithDividers() },
        Example("2.4 Añadir Cabeceras Fijas") { ListWithStickyHeaders() },
        Example("2.5 Añadir Lista Horizontal Dentro De Lista Vertical") {
            VerticalListWithHorizontalList()
        }
    )

    ExamplesMenu(options)
}

@Composable
private fun Gestures() {
    val options = listOf(
        Example("3.1 Click En Item De Lista") { ClickableListItems() },
        Example("3.2 Eventos De Scrolling") { ScrollingEvents() },
        Example("3.3 Scrollear Hacia Un Item") { ProgrammaticScrolling() },
    )
    ExamplesMenu(options)
}

@Composable
private fun Controls() {
    val options = listOf(
        Example("5.1 Lista Con CheckBox") { SelectableList() },
        Example("5.2 Lista Con Switch") { SwitchPreferenceItem() },
        Example("5.3 Icono Para Expandir Y Colapsar") { ExpandableList() },
    )
    ExamplesMenu(options)
}

@Composable
private fun Theming() {
    CustomList()
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ExamplesMenu(options: List<Example>) {
    var exampleMenuOpen by remember { mutableStateOf(false) }
    var selectedOption by remember { mutableStateOf(options.first()) }

    Column {

        ExposedDropdownMenuBox(
            expanded = exampleMenuOpen,
            onExpandedChange = {
                exampleMenuOpen = !exampleMenuOpen
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp, start = 16.dp, end = 16.dp)
        ) {
            TextField(
                readOnly = true,
                value = selectedOption.title,
                onValueChange = { },
                label = { Text("Ejemplo") },
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(
                        expanded = exampleMenuOpen
                    )
                },
                colors = ExposedDropdownMenuDefaults.textFieldColors(),
                modifier = Modifier.fillMaxWidth()
            )
            ExposedDropdownMenu(
                expanded = exampleMenuOpen,
                onDismissRequest = { exampleMenuOpen = false }
            ) {
                options.forEach { option ->
                    DropdownMenuItem(
                        onClick = {
                            selectedOption = option
                            exampleMenuOpen = false
                        }
                    ) {
                        Text(text = option.title)
                    }
                }
            }
        }

        Divider(modifier = Modifier.padding(vertical = 16.dp))

        selectedOption.content()
    }


}

@Preview
@Composable
fun ListsScreenPreview() {
    SurfaceForPreview(
        modifier = Modifier.fillMaxSize()
    ) {

        ListsScreen()
    }
}