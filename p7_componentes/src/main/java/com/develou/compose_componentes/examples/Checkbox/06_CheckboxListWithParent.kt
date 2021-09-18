package com.develou.compose_componentes.examples.Checkbox

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.unit.dp

@Composable
fun CheckboxListWithParent(
    options: List<Option>,
    parentState: ToggleableState,
    onParentClick: () -> Unit,
    parentLabel: String
) {
    Column {
        LabelledTriStateCheckbox(
            state = parentState,
            onClick = onParentClick,
            label = parentLabel
        )

        options.forEach { option ->
            LabelledCheckbox(
                checked = option.checked,
                onCheckedChange = option.onCheckedChange,
                label = option.label,
                enabled = option.enabled,
                modifier = Modifier.padding(start = 32.dp)
            )
        }
    }
}

@Composable
fun CheckboxListWithParentExample() {
    val labels = listOf(
        "Interbrand",
        "Toyota",
        "Mercedes Benz",
        "BMW",
        "Honda",
        "Hyundai",
        "Tesla",
        "Ford"
    )

    val childStates = remember {
        val elements = Array(labels.size) { false }
        mutableStateListOf(*elements)
    }

    val options = labels.mapIndexed { index, label ->
        Option(
            checked = childStates[index],
            onCheckedChange = { childStates[index] = it },
            label = label,
        )
    }

    val parentState = remember(*childStates.toTypedArray()) {
        when {
            childStates.all { it } -> ToggleableState.On
            childStates.none { it } -> ToggleableState.Off
            else -> ToggleableState.Indeterminate
        }
    }

    val onParentClick = {
        val derivedState = parentState != ToggleableState.On
        childStates.fill(derivedState)
    }

    CheckboxListWithParent(
        options = options,
        parentState = parentState,
        onParentClick = onParentClick,
        parentLabel = "Marcas"
    )
}