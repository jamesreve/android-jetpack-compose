package com.develou.compose_componentes.examples.Checkbox

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

@Composable
fun DisabledCheckboxExample() {
    val gameReleases = listOf(
        "Hitman 3",
        "Monster Hunter World: Iceborne",
        "Days Gone",
        "Pokémon Rumble Rush"
    )

    val options = gameReleases.map { option ->
        val checked = remember { mutableStateOf(false) }
        Option(
            checked = checked.value,
            onCheckedChange = { checked.value = it },
            label = option
        )
    }

    val numberOfMarks = options.count { it.checked }

    if (numberOfMarks == 2) {
        options
            .filterNot { option -> option.checked }
            .forEach { unchecked -> unchecked.enabled = false }
    }

    CheckboxList(
        options = options,
        listTitle = "En la siguiente lista hay dos videojuegos lanzados en el 2021." +
                " Selecciona tus respuestas:"
    )
}