package com.develou.compose_componentes.examples.Checkbox

import androidx.compose.material.TriStateCheckbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.state.ToggleableState

@Composable
fun TriStateCheckboxExample() {
    val state = remember { mutableStateOf(ToggleableState.Off) }
    TriStateCheckbox(
        state = state.value,
        onClick = {
            state.value = when (state.value) {
                ToggleableState.Off -> ToggleableState.On
                ToggleableState.On -> ToggleableState.Indeterminate
                ToggleableState.Indeterminate -> ToggleableState.Off
            }
        }
    )
}