package com.develou.compose_componentes.examples.Card

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.RadioButton
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp

@Composable
fun StylingCard() {
    val backgroundColorOptions = listOf("Amarillo", "Azul", "Rojo")
    val contentColorOptions = listOf("Gris Azulado", "Indigo", "Marrón")
    val shapeOptions = listOf("Redondeada", "Recortada")

    var backgroundColorSelection by remember { mutableStateOf(backgroundColorOptions.first()) }
    var contentColorSelection by remember { mutableStateOf(contentColorOptions.first()) }
    var shapeSelection by remember { mutableStateOf(shapeOptions.first()) }

    Column {

        ConfigSection(
            title = "backgroundColor",
            options = backgroundColorOptions,
            selection = backgroundColorSelection,
            onOptionSelected = { backgroundColorSelection = it },
            modifier = Modifier.padding(top = 16.dp, bottom = 8.dp, start = 16.dp, end = 16.dp)
        )

        ConfigSection(
            title = "contentColor",
            options = contentColorOptions,
            selection = contentColorSelection,
            onOptionSelected = { contentColorSelection = it },
            modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp)
        )

        ConfigSection(
            title = "shape",
            options = shapeOptions,
            selection = shapeSelection,
            onOptionSelected = { shapeSelection = it },
            modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp)
        )

        Divider()

        StandardCard(
            modifier = Modifier.padding(16.dp),
            background = configBackgroundColor(backgroundColorSelection),
            contentColor = configContentColor(contentColorSelection),
            shape = configShape(shapeSelection)
        )
    }
}

@Composable
private fun configBackgroundColor(backgroundColorSelection: String) =
    when (backgroundColorSelection) {
        "Amarillo" -> Color(0xFFFFF176)
        "Azul" -> Color(0xFF64B5F6)
        "Rojo" -> Color(0xFFE57373)
        else -> Color.White
    }

private fun configContentColor(contentColorSelection: String) = when (contentColorSelection) {
    "Gris Azulado" -> Color(0xFF263238)
    "Índigo" -> Color(0xFF1A237E)
    "Marrón" -> Color(0xFF3e2723)
    else -> Color.Black
}

@Composable
private fun configShape(
    selection: String
): Shape {
    val cornerSize = 16.dp

    return if (selection == "Redondeada")
        RoundedCornerShape(cornerSize)
    else
        CutCornerShape(cornerSize)
}

@Composable
fun ConfigSection(
    title: String,
    options: List<String>,
    selection: String,
    onOptionSelected: (String) -> Unit,
    modifier: Modifier = Modifier
) {

    Column(modifier = modifier) {
        Text(text = title, style = MaterialTheme.typography.caption)
        Row {
            options.forEach {
                ConfigRadioButton(
                    label = it,
                    selected = selection == it,
                    onClick = { onOptionSelected(it) }
                )
            }

        }
    }
}

@Composable
fun ConfigRadioButton(label: String, selected: Boolean, onClick: () -> Unit) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        RadioButton(selected = selected, onClick = onClick)
        Text(text = label)
    }
}