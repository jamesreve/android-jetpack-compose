package com.develou.compose_componentes.examples.Card

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ElevatedCard() {
    StandardCard()
}

@Composable
fun OutlinedCard() {
    StandardCard(
        elevation = 0.dp,
        border = BorderStroke(1.dp, Color.LightGray),
        shape = RoundedCornerShape(16.dp)
    )
}

@Composable
fun CardTypes() {
    val options = listOf("Elevada", "Delineada")
    var selection by remember { mutableStateOf(options.first()) }

    Column {

        ConfigSection(
            title = "Tipo de card",
            options = options,
            selection = selection,
            onOptionSelected = { selection = it },
            modifier = Modifier.padding(16.dp)
        )
        Divider()

        Box(modifier = Modifier.padding(16.dp)) {
            when (selection) {
                "Elevada" -> ElevatedCard()
                "Delineada" -> OutlinedCard()
            }
        }
    }

}