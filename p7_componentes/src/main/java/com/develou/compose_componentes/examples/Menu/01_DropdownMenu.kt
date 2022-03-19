package com.develou.compose_componentes.examples.Menu

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.*
import androidx.compose.material.TabRowDefaults.Divider
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import com.develou.compose_componentes.R
import com.develou.compose_componentes.examples.Menu.MenuItem.Divider
import com.develou.compose_componentes.examples.Menu.MenuItem.Option

@Composable
fun TasksUi() {
    var taskMenuOpen by remember { mutableStateOf(false) }
    var action by remember { mutableStateOf("Ninguna") }

    Box(
        Modifier
            .border(width = 1.dp, shape = RectangleShape, color = Color.LightGray)
            .padding(horizontal = 16.dp)
            .fillMaxWidth()
            .height(56.dp)

    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .align(Alignment.CenterStart),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = false,
                onCheckedChange = {},
                modifier = Modifier
                    .size(24.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column {

                Text(
                    text = "Limpiar alacena"
                )
                Text(text = "Acción: $action", style = MaterialTheme.typography.caption)
            }

        }
        IconButton(
            onClick = { taskMenuOpen = true },
            modifier = Modifier
                .size(24.dp)
                .align(Alignment.CenterEnd)
        ) {
            Icon(
                imageVector = Icons.Filled.MoreVert,
                contentDescription = "Acciones para tarea"
            )
            TaskMenu(
                expanded = taskMenuOpen,
                onItemClick = { action = it },
                onDismiss = {
                    taskMenuOpen = false
                }
            )
        }
    }
}

@Composable
fun TaskMenu(
    expanded: Boolean,
    onItemClick: (String) -> Unit,
    onDismiss: () -> Unit
) {

    val options = listOf(
        "Cambiar nombre",
        "Enviar por email",
        "Copiar enlace",
        "Ocultar subtareas completas",
        "Eliminar"
    )

    DropdownMenu(
        expanded = expanded,
        onDismissRequest = onDismiss
    ) {
        options.forEach { option ->
            DropdownMenuItem(
                onClick = {
                    onItemClick(option)
                    onDismiss()
                }
            ) {
                Text(text = option)
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ImageUi() {
    var imageMenuOpen by remember { mutableStateOf(false) }

    Box(contentAlignment = Alignment.TopStart) {
        Image(
            painterResource(id = R.drawable.image),
            contentDescription = null,
            modifier = Modifier
                .combinedClickable(
                    onLongClick = {
                        imageMenuOpen = true
                    },
                    onClick = {},
                    onDoubleClick = {}
                )
                .height(250.dp)
        )
        ImageMenu(
            expanded = imageMenuOpen,
            onItemClick = {},
            onDismiss = {
                imageMenuOpen = false
            }
        )
    }
}

@Composable
fun ImageMenu(
    expanded: Boolean,
    onItemClick: (Option) -> Unit,
    onDismiss: () -> Unit
) {
    val options = listOf(
        Option(
            "Previsualizar",
            ImageVector.vectorResource(R.drawable.ic_visibility)
        ),
        Option("Compartir", Icons.Filled.Share),
        Option("Copiar Enlace", ImageVector.vectorResource(R.drawable.ic_link)),
        Option("Descargar", ImageVector.vectorResource(R.drawable.ic_file_download), false),
        Divider,
        Option("Denunciar", ImageVector.vectorResource(R.drawable.ic_flag)),
    )

    DropdownMenu(
        expanded = expanded,
        onDismissRequest = onDismiss,
        offset = DpOffset(50.dp, 250.dp),
        modifier = Modifier.width(192.dp)
    ) {
        options.forEach { option ->
            when (option) {
                is Option -> {
                    DropdownMenuItem(
                        enabled = option.enabled,
                        onClick = {
                            onItemClick(option)
                            onDismiss()
                        }
                    ) {
                        option.icon?.let {
                            val values = LocalContentAlpha provides
                                    if (option.enabled)
                                        ContentAlpha.medium
                                    else ContentAlpha.disabled
                            CompositionLocalProvider(values) {
                                Icon(it, contentDescription = null)
                            }
                        }

                        Spacer(Modifier.width(24.dp))

                        Text(text = option.name)
                    }
                }
                Divider -> Divider()
            }

        }
    }
}

@Composable
fun ThemedTaskMenu() {
    var taskMenuOpen by remember { mutableStateOf(false) }
    Box {
        OutlinedButton(onClick = { taskMenuOpen = true }) {
            Text(text = "Abrir Menú")
        }
        MaterialTheme(
            colors = MaterialTheme.colors.copy(surface = Color(0xFFe3f2fd)),
            shapes = MaterialTheme.shapes.copy(medium = CutCornerShape(size = 25f))
        ) {
            TaskMenu(
                expanded = taskMenuOpen,
                onItemClick = {},
                onDismiss = { taskMenuOpen = false }
            )
        }
    }
}