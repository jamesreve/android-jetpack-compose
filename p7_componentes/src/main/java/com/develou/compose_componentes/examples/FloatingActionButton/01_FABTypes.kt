package com.develou.compose_componentes.examples.FloatingActionButton

import androidx.compose.foundation.layout.size
import androidx.compose.material.ExtendedFloatingActionButton
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun DefaultFloatingActionButtonExample() {
    FloatingActionButton(onClick = { /* Tus acciones */ }) {
        Icon(imageVector = Icons.Default.Add, contentDescription = "Crear nota")
    }
}

@Composable
fun MiniFloatingActionButtonExample() {
    val miniFabSize = 40.dp
    FloatingActionButton(
        onClick = { /* Tus acciones */ },
        modifier = Modifier.size(miniFabSize)
    ) {
        Icon(imageVector = Icons.Default.Add, contentDescription = "Crear nota")
    }
}

@Composable
fun ExtendedFloatingActionButtonExample() {
    ExtendedFloatingActionButton(
        text = { Text("COMPARTIR") },
        onClick = { /* Tus acciones */ },
        icon = {
            Icon(
                imageVector = Icons.Default.Share,
                contentDescription = "Compartir foto"
            )
        })
}
