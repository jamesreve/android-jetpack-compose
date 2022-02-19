package com.develou.compose_componentes.examples.RadioButton

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.RadioButtonColors
import androidx.compose.material.RadioButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp

data class TemplateOption(
    val label: String,
    val available: Boolean = true
)

@Composable
fun TemplatesSelector(
    modifier: Modifier,
    options: List<TemplateOption>,
    selection: TemplateOption,
    onItemClick: (TemplateOption) -> Unit,
    colors: RadioButtonColors = RadioButtonDefaults.colors()
) {
    Column(modifier = modifier) {
        options.forEach { option ->
            LabelledRadioButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .selectable(
                        selected = option == selection,
                        onClick = { onItemClick(option) },
                        role = Role.RadioButton,
                        enabled = option.available
                    ),
                label = option.label,
                selected = option == selection,
                onClick = null,
                enabled = option.available,
                colors = colors
            )
        }
    }
}

@Composable
fun Example5() {

    /* Este valor es solo para facilitar el ejemplo. Las opciones de plantilla
     Deberían venir calculadas */
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
        }
    )
}