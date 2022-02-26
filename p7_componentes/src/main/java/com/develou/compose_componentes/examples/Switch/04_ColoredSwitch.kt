package com.develou.compose_componentes.examples.Switch

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.SwitchDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.develou.compose_componentes.examples.Checkbox.LabelledCheckbox
import com.develou.compose_componentes.examples.RadioButton.SurfaceForPreview

val Blue500 = Color(0xFF2196F3)
val LightBlue500 = Color(0xFF00BCD4)
val LightBlue300 = Color(0xFF4DD0E1)

@Composable
fun Example4() {
    val (isPremium, setIsPremium) = remember { mutableStateOf(false) }
    val (notifyWeekly, setNotifyWeekly) = remember { mutableStateOf(false) }

    Column(Modifier.padding(vertical = 16.dp)) {

        LabelledCheckbox(
            checked = isPremium,
            onCheckedChange = setIsPremium,
            label = "¿Usuario premium?"
        )

        Spacer(modifier = Modifier.height(56.dp))

        LabelledSwitch(
            checked = notifyWeekly,
            label = "Habilitar informes semanales",
            onCheckedChange = setNotifyWeekly,
            enabled = isPremium,
            colors = SwitchDefaults.colors(
                checkedThumbColor = Blue500,
                uncheckedThumbColor = LightBlue500,
                uncheckedTrackColor = LightBlue300
            )
        )
    }
}

@Composable
@Preview
fun Example4Preview() {
    SurfaceForPreview {
        Example4()
    }
}