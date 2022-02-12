package com.develou.compose_componentes.examples.Button

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.develou.compose_componentes.R
import java.time.LocalDateTime
import kotlin.random.Random

@Composable
fun TextButtonExample() {
    var counter by remember { mutableStateOf(0) }

    TextButton(onClick = { counter++ }) {
        Text("CLICS: $counter")
    }
}

@Composable
fun OutlinedButtonExample() {
    var date by remember { mutableStateOf(LocalDateTime.now()) }

    Column {

        OutlinedButton(
            onClick = { date = LocalDateTime.now() },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text("INFORMAR")
        }
        Spacer(Modifier.size(16.dp))
        Text(
            "Fecha actual -> $date",
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
    }
}

@Composable
fun ContainedButtonExample() {
    val WIDTH1 = 150.dp
    val WIDTH2 = 200.dp
    val WIDTH3 = 300.dp

    var width by remember { mutableStateOf(WIDTH1) }

    Button(
        onClick = {
            width = when (width) {
                WIDTH1 -> WIDTH2
                WIDTH2 -> WIDTH3
                else -> WIDTH1
            }
        },
        modifier = Modifier.width(width)
    ) {
        Text("CAMBIAR")
    }
}

@Composable
fun ToggleButtonExample() {
    var checked by remember { mutableStateOf(false) } //1

    IconToggleButton(checked = checked, onCheckedChange = { checked = it }) { //2
        Icon(
            painter = painterResource( //3
                if (checked) R.drawable.ic_bookmark
                else R.drawable.ic_bookmark_border
            ),
            contentDescription = //4
            if (checked) "Añadir a marcadores"
            else "Quitar de marcadores",
            tint = Color(0xFF26C6DA) //5
        )
    }
}

@Composable
fun IconButtonExample() {
    var color by remember { mutableStateOf(Color.LightGray) }

    IconButton(
        onClick = {
            val randomColor = Color(Random.nextLong(0xFF000000, 0xFFFFFFFF))
            color = randomColor
        }) {
        Icon(
            Icons.Filled.Home,
            contentDescription = "Cambiar color",
            tint = color
        )
    }
}

