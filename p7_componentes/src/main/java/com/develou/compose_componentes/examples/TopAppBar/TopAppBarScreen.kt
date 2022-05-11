package com.develou.compose_componentes.examples.TopAppBar

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.develou.compose_componentes.R
import com.develou.compose_componentes.examples.Example
import com.develou.compose_componentes.examples.RadioButton.SurfaceForPreview
import kotlinx.coroutines.launch


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun TopAppBarScreen() {
    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()

    val showSnackbar: (String) -> Unit = {
        coroutineScope.launch {
            scaffoldState.snackbarHostState.showSnackbar("Click en \"$it\"")
        }
    }

    val options = listOf(
        Example("1.1 TopAppBar con slots fijos") { DetailTopAppBar() },
        Example("1.2 TopAppBar con título centrado") { CenterAlignedTopAppBar() },
        Example("2.1 Click en action items") { GeneralizedActionItems(showSnackbar) },
        Example("2.2 Overflow menu") { OverflowMenuExample(showSnackbar) },
        Example("3.1 TopAppBar prominente") { ProminentTopAppBar() },
        Example("3.2 TopAppBar prominente con imagen") { ProminentTopAppBarWithImage() },
        Example("4.1 Cambiar color de fondo") { TopAppBarCustomBackground() },
        Example("4.2 Cambiar color de contenido") { TopAppBarCustomContentColor() },
        Example("4.3 Cambiar elevación") { TopAppBarCustomElevation() },
        Example("5 Tematizar TopAppBar") { ThemedTopAppBar() },
    )
    val (appBar, setAppBar) = remember { mutableStateOf(options.first().content) }

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = { appBar() }
    ) {
        TopAppBarExamplesMenu(options, setAppBar)
    }
}

@Composable
private fun GeneralizedActionItems(showSnackbar: (String) -> Unit) {
    ListTopAppBar(
        openDrawer = {},
        actionItems = listOf(
            ActionItem(
                "Buscar",
                Icons.Filled.Search,
                action = { showSnackbar("Buscar") },
                order = 1
            ),
            ActionItem(
                "Filtrar",
                ImageVector.vectorResource(id = R.drawable.ic_filter_list),
                action = { showSnackbar("Filtrar") },
                order = 2
            )
        )
    )
}

@Composable
private fun OverflowMenuExample(showSnackbar: (String) -> Unit) {

    val actionItems = listOf(
        ActionItem(
            "Buscar",
            Icons.Filled.Search,
            action = { showSnackbar("Buscar") },
            order = 1
        ),
        ActionItem(
            "Filtrar",
            ImageVector.vectorResource(id = R.drawable.ic_filter_list),
            action = { showSnackbar("Filtrar") },
            order = 2
        ),
        ActionItem(
            "Refrescar",
            action = { showSnackbar("Refrescar") },
            order = 3
        ),
        ActionItem(
            "Ajustes",
            action = { showSnackbar("Ajustes") },
            order = 4
        ),
        ActionItem(
            "Enviar sugerencias",
            action = { showSnackbar("Enviar sugerencias") },
            order = 5
        ),
        ActionItem(
            "Ayuda",
            action = { showSnackbar("Ayuda") },
            order = 6
        ),
        ActionItem(
            "Cerrar sesión",
            action = { showSnackbar("Cerrar sesión") },
            order = 7
        )
    )

    ListTopAppBar(
        openDrawer = { /* Abrimos un drawer */ },
        actionItems = actionItems
    )
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
private fun TopAppBarExamplesMenu(
    options: List<Example>,
    setAppBar: (@Composable () -> Unit) -> Unit
) {
    var exampleMenuOpen by remember { mutableStateOf(false) }
    var selectedOption by remember { mutableStateOf(options.first()) }

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
                        setAppBar(option.content)
                        selectedOption = option
                        exampleMenuOpen = false
                    }
                ) {
                    Text(text = option.title)
                }
            }
        }
    }

}

@Composable
@Preview
private fun TopAppBarScreenPreview() {
    SurfaceForPreview {
        TopAppBarScreen()
    }
}