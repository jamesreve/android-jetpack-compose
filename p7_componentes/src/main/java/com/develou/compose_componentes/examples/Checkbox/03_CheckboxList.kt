package com.develou.compose_componentes.examples.Checkbox

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

data class Option(
    var checked: Boolean,
    var onCheckedChange: (Boolean) -> Unit = {},
    val label: String,
    var enabled: Boolean = true
)

@Composable
fun CheckboxList(options: List<Option>, listTitle: String) {
    Column {
        Text(listTitle, textAlign = TextAlign.Justify)
        Spacer(Modifier.size(16.dp))
        options.forEach { option ->
            LabelledCheckbox(
                checked = option.checked,
                onCheckedChange = option.onCheckedChange,
                label = option.label,
                enabled = option.enabled
            )
        }
    }
}

@Composable
fun CheckboxListExample() {
    val disciplines = listOf("Programación", "Diseño", "Audio", "Arte")

    val options = disciplines.map { label ->
        val checked = remember { mutableStateOf(false) }
        Option(
            checked = checked.value,
            onCheckedChange = { checked.value = it },
            label = label,
        )
    }

    CheckboxList(options = options, listTitle = "Disciplinas")
}
