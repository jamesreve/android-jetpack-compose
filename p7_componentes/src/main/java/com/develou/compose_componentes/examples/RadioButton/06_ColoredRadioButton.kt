package com.develou.compose_componentes.examples.RadioButton

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.RadioButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun Example6() {
    val isPremium = false

    val templateOptions = listOf(
        TemplateOption("Por defecto"),
        TemplateOption("Elegante"),
        TemplateOption("Audaz"),
        TemplateOption("Personalizada", isPremium)
    )
    val currentSelection = remember { mutableStateOf(templateOptions.first()) }

    TemplatesSelector(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        options = templateOptions,
        selection = currentSelection.value,
        onItemClick = { clickedItem ->
            currentSelection.value = clickedItem
        },
        colors = RadioButtonDefaults.colors(
            selectedColor = Color(0xFF0d47a1),
            unselectedColor = Color(0xFF2196f3),
            disabledColor = Color(0xFFbbdefb)
        )
    )
}