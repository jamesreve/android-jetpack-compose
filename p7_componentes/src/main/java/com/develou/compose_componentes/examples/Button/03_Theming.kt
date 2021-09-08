package com.develou.compose_componentes.examples.Button

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ButtonShapeExample() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text("Formas Personalizadas", style = MaterialTheme.typography.h6)
        Spacer(Modifier.size(8.dp))
        Button(onClick = { }, shape = CutCornerShape(0)) {
            Text("BOTÓN")
        }
        Spacer(Modifier.size(8.dp))
        Button(onClick = { }, shape = CutCornerShape(4.dp)) {
            Text("BOTÓN")
        }
        Spacer(Modifier.size(8.dp))
        Button(onClick = { }, shape = RoundedCornerShape(50)) {
            Text("BOTÓN")
        }
    }
}

@Composable
fun ColorsButtonExample() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text("Colores Personalizados", style = MaterialTheme.typography.h6)
        Spacer(Modifier.size(8.dp))
        TextButton(
            onClick = { },
            colors = ButtonDefaults.textButtonColors(
                contentColor = Color(0xFFEC407A)
            )
        ) {
            Text("TEXT BUTTON")
        }
        Spacer(Modifier.size(8.dp))
        OutlinedButton(
            onClick = { },
            colors = ButtonDefaults.outlinedButtonColors(
                contentColor = Color(0xFFAB47BC)
            )
        ) {
            Text("OUTLINED BUTTON")
        }
        Spacer(Modifier.size(8.dp))
        Button(
            onClick = { },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color(0xFF7E57C2),
                contentColor = Color(0xFFFFEE58)
            )
        ) {
            Text("CONTAINED BUTTON")
        }
    }
}