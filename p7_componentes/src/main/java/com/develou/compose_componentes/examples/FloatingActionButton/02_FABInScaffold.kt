package com.develou.compose_componentes.examples.FloatingActionButton

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun FABInScaffoldExample() {
    Scaffold(
        topBar = {
            TopAppBar { }
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { /* Tus acciones */ }) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Crear nota"
                )
            }
        },
        floatingActionButtonPosition = FabPosition.End
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text("Floating Action Button En Scaffold")
        }
    }
}