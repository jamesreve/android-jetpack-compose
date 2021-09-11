package com.develou.compose_componentes.examples.FloatingActionButton

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.ExperimentalUnitApi
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

@ExperimentalUnitApi
@Composable
fun FABsScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        // Cambia este composable por el que deseas ejecutar
        FABTypographyExample()
    }
}

@Composable
fun FABScaffoldScreen(){
    FABInScaffoldExample()
}

@ExperimentalUnitApi
@Composable
@Preview
fun FABsScreenPreview() {
    MaterialTheme {
        Surface(
            modifier = Modifier
                .background(Color.White)
        ) {
            FABsScreen()
        }
    }
}