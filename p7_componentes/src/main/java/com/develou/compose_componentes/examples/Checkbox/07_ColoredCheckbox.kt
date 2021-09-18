package com.develou.compose_componentes.examples.Checkbox

import androidx.compose.foundation.layout.Column
import androidx.compose.material.CheckboxDefaults
import androidx.compose.material.ContentAlpha
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun ColoredCheckboxExample() {

    val checkedColor = Color(0xFFE1BEE7)
    val checkmarkColor = Color(0xFF4A148C)
    val uncheckedColor = Color(0xFF7E57C2)
    val disabledColor = Color.LightGray
    val disabledIndeterminateColor = checkedColor.copy(ContentAlpha.disabled)

    Column {
        LabelledCheckbox(
            label = "Enabled+Selected",
            checked = true,
            onCheckedChange = { },
            colors = CheckboxDefaults.colors(
                checkedColor = checkedColor,
                checkmarkColor = checkmarkColor,
            )
        )

        LabelledCheckbox(
            label = "Enabled+Unselected",
            checked = false,
            onCheckedChange = { },
            colors = CheckboxDefaults.colors(
                uncheckedColor = uncheckedColor,
            )
        )

        LabelledCheckbox(
            label = "Disabled+Unselected",
            checked = false,
            onCheckedChange = { },
            colors = CheckboxDefaults.colors(
                disabledColor = disabledColor,
            ),
            enabled = false
        )

        LabelledCheckbox(
            label = "Disabled+Selected",
            checked = true,
            onCheckedChange = { },
            colors = CheckboxDefaults.colors(
                disabledColor = disabledColor,
            ),
            enabled = false
        )

        LabelledTriStateCheckbox(
            label = "Disabled+Indeterminate",
            state = ToggleableState.Indeterminate,
            onClick = { },
            enabled = false,
            colors = CheckboxDefaults.colors(
                disabledIndeterminateColor = disabledIndeterminateColor
            )
        )
    }
}
