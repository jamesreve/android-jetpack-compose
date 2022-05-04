package com.develou.compose_componentes.examples.Scaffold

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.develou.compose_componentes.examples.RadioButton.LabelledRadioButton
import kotlinx.coroutines.launch
import kotlin.random.Random

private val appBarOptions = listOf("TopAppBar", "BottomAppBar")

@Composable
fun ScaffoldScreen() {
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()

    val (appBarSelected, selectAppBar) = remember { mutableStateOf(appBarOptions.first()) }
    var scaffoldBackgroundColor by remember { mutableStateOf(Color.White) }

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            if (appBarSelected == appBarOptions[0])
                ExampleTopAppBar(
                    onMenuButtonClick = {
                        scope.launch {
                            scaffoldState.drawerState.open()
                        }
                    },
                    onActionButtonClick = {
                        scope.launch {
                            scaffoldState.snackbarHostState.showSnackbar("Clic en '$it'")
                        }
                    }
                )
        },
        bottomBar = {
            if (appBarSelected == appBarOptions[1])
                ExampleBottomAppBar()
        },
        modifier = Modifier.fillMaxSize(),
        floatingActionButton = {
            FloatingActionButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Filled.Add, contentDescription = "Crear")
            }
        },
        floatingActionButtonPosition = FabPosition.Center,
        isFloatingActionButtonDocked = true,
        drawerContent = {
            DrawerContent {
                scope.launch { scaffoldState.drawerState.close() }
            }
        },
        backgroundColor = scaffoldBackgroundColor
    ) { padding ->
        ScaffoldContent(
            padding = padding,
            appBarSelected = appBarSelected,
            selectAppBar = selectAppBar,
            onButtonClick = { scaffoldBackgroundColor = Color(Random.nextLong(0xFFFFFFFF)) }
        )
    }
}

@Composable
private fun ExampleTopAppBar(
    onMenuButtonClick: () -> Unit,
    onActionButtonClick: (String) -> Unit
) {
    TopAppBar(
        navigationIcon = {
            IconButton(onClick = onMenuButtonClick) {
                Icon(imageVector = Icons.Filled.Menu, contentDescription = "Abrir menú desplegable")
            }
        },
        title = { Text(text = "Scaffold") },
        actions = {
            IconButton(onClick = { onActionButtonClick("Favorito") }) {
                Icon(imageVector = Icons.Filled.Favorite, contentDescription = "Favorito")
            }
            IconButton(onClick = { onActionButtonClick("Buscar") }) {
                Icon(imageVector = Icons.Filled.Search, contentDescription = "Buscar")
            }
            IconButton(onClick = { onActionButtonClick("Más") }) {
                Icon(imageVector = Icons.Filled.MoreVert, contentDescription = "Más")
            }
        }
    )
}

@Composable
private fun ExampleBottomAppBar() {
    BottomAppBar {
        CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.high) {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(Icons.Filled.Menu, contentDescription = "Abri menú desplegable")
            }
        }

        Spacer(Modifier.weight(1f, true))

        IconButton(onClick = { /*TODO*/ }) {
            Icon(imageVector = Icons.Filled.Search, contentDescription = "Buscar")
        }
        IconButton(onClick = { /*TODO*/ }) {
            Icon(imageVector = Icons.Filled.MoreVert, contentDescription = "Más")
        }
    }
}

@Composable
private fun DrawerContent(closeDrawer: () -> Unit) {
    val sections = listOf(
        "Bandeja de entrada",
        "Enviados", "Archivados",
        "Favoritos",
        "Papelera"
    )

    Column(Modifier.padding(vertical = 8.dp)) {
        sections.forEach { section ->
            TextButton(
                onClick = closeDrawer,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp)
            ) {
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.CenterStart
                ) {

                    val textColor = MaterialTheme.colors.onSurface
                    Text(
                        text = section,
                        style = MaterialTheme.typography.body2.copy(color = textColor)
                    )
                }
            }
        }
    }
}

@Composable
fun ScaffoldContent(
    padding: PaddingValues,
    appBarSelected: String,
    selectAppBar: (String) -> Unit,
    onButtonClick: () -> Unit
) {
    Column(
        modifier = Modifier.padding(top = 16.dp, bottom = padding.calculateBottomPadding()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row {
            LabelledRadioButton(
                label = appBarOptions[0],
                selected = appBarSelected == appBarOptions[0],
                onClick = { selectAppBar(appBarOptions[0]) })
            LabelledRadioButton(
                label = appBarOptions[1],
                selected = appBarSelected == appBarOptions[1],
                onClick = { selectAppBar(appBarOptions[1]) }
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = onButtonClick) {
            Text(text = "Cambiar backgroundColor")
        }
    }
}

@Composable
@Preview
private fun ScaffoldScreenPreview() {
    MaterialTheme {
        ScaffoldScreen()
    }
}