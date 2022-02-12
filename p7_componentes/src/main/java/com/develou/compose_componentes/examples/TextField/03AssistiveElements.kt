package com.develou.compose_componentes.examples.TextField

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.develou.compose_componentes.R

@Composable
fun HelperTextExample() {
    var phone by remember {
        mutableStateOf("")
    }

    Column {
        TextField(
            value = phone,
            onValueChange = { phone = it },
            label = { Text("Teléfono*") }
        )
        Text(
            text = "*Obligatorio",
            color = MaterialTheme.colors.onSurface.copy(alpha = ContentAlpha.medium),
            style = MaterialTheme.typography.caption,
            modifier = Modifier.padding(start = 16.dp)
        )
    }
}

@Composable
fun ErrorTextExample() {
    var name by remember { mutableStateOf("") }
    var nameError by remember { mutableStateOf(false) } // 1

    Column {
        TextField(
            value = name,
            onValueChange = {
                name = it
                nameError = false // 2
            },
            label = { Text("Nombre") },
            isError = nameError // 3
        )

        val assistiveElementText = if (nameError) "Error: Obligatorio" else "*Obligatorio" // 4
        val assistiveElementColor = if (nameError) { // 5
            MaterialTheme.colors.error
        } else {
            MaterialTheme.colors.onSurface.copy(alpha = ContentAlpha.medium)
        }

        Text(// 6
            text = assistiveElementText,
            color = assistiveElementColor,
            style = MaterialTheme.typography.caption,
            modifier = Modifier.padding(start = 16.dp)
        )

        Spacer(Modifier.size(16.dp))

        Button(
            onClick = { nameError = name.isBlank() }, // 7
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text("GUARDAR")
        }
    }
}

@Composable
fun LeadingIconExample() {
    var createdDate by remember {
        mutableStateOf("")
    }

    TextField(
        value = createdDate,
        onValueChange = { createdDate = it },
        label = { Text("Fecha de inscripción") },
        placeholder = { Text("") },
        leadingIcon = {
            IconButton(onClick = { }) {
                Icon(
                    imageVector = Icons.Filled.DateRange,
                    contentDescription = "Botón para elegir fecha"
                )
            }
        }
    )
}

@Composable
fun TrailingIconExample() {
    var name by remember {
        mutableStateOf("Carlos")
    }

    TextField(
        value = name,
        onValueChange = { name = it },
        label = { Text("Nombre") },
        trailingIcon = {
            if (name.isNotBlank())
                IconButton(onClick = { name = "" }) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_cancel),
                        contentDescription = "Limpiar campo de nombre"
                    )
                }
        }
    )
}

@Composable
fun CharacterCounterExample() {
    var name by remember {
        mutableStateOf("")
    }
    val counterMaxLength = 20 //1

    Column {
        TextField(
            value = name,
            onValueChange = {
                if (it.length <= counterMaxLength) //2
                    name = it
            },
            label = { Text("Nombre") }
        )
        Text(
            text = "${name.length}/$counterMaxLength",//3
            color = MaterialTheme.colors.onSurface.copy(alpha = ContentAlpha.medium),
            style = MaterialTheme.typography.caption,
            modifier = Modifier
                .padding(start = 16.dp)
                .align(Alignment.End) //4
        )
    }
}