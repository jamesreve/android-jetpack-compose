package com.develou.compose_componentes.examples.Button

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ButtonWithIconExample() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text("Botones Con Icono", style = MaterialTheme.typography.h6)
        Spacer(Modifier.size(8.dp))
        TextButton(onClick = { }) {
            Icon(
                imageVector = Icons.Default.ShoppingCart,
                contentDescription = null,
                modifier = Modifier.size(ButtonDefaults.IconSize)
            )
            Spacer(Modifier.size(ButtonDefaults.IconSpacing))
            Text("BOTÓN")
        }
        Spacer(Modifier.size(8.dp))
        OutlinedButton(onClick = { }) {
            Icon(
                imageVector = Icons.Default.ShoppingCart,
                contentDescription = null,
                modifier = Modifier.size(ButtonDefaults.IconSize)
            )
            Spacer(Modifier.size(ButtonDefaults.IconSpacing))
            Text("BOTÓN")
        }
        Spacer(Modifier.size(8.dp))
        Button(onClick = { }) {
            Icon(
                imageVector = Icons.Default.ShoppingCart,
                contentDescription = null,
                modifier = Modifier.size(ButtonDefaults.IconSize)
            )
            Spacer(Modifier.size(ButtonDefaults.IconSpacing))
            Text("BOTÓN")
        }
    }
}

@Composable
fun DisabledButtonExample() {
    var tag by remember { mutableStateOf("") }

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        TextField(
            value = tag,
            onValueChange = { tag = it },
            label = { Text("Etiqueta") }
        )
        Spacer(Modifier.size(8.dp))
        Button(onClick = { }, enabled = tag.length > 2) {
            Text("GUARDAR")
        }
    }
}

@Composable
fun BorderExample() {
    OutlinedButton(
        onClick = { }, border = BorderStroke(
            width = 2.dp,
            brush = Brush.horizontalGradient(
                listOf(
                    Color(0xFF42A5F5),
                    Color(0xFFFFA726)
                )
            )
        )
    ) {
        Text("JUGAR", color = Color(0xFF5C6BC0))
    }
}