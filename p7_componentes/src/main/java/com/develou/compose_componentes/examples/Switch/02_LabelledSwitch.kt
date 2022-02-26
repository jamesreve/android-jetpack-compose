package com.develou.compose_componentes.examples.Switch

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.develou.compose_componentes.examples.RadioButton.SurfaceForPreview

@Composable
fun LabelledSwitch(
    modifier: Modifier = Modifier,
    checked: Boolean,
    label: String,
    onCheckedChange: ((Boolean) -> Unit),
    enabled: Boolean = true,
    colors: SwitchColors = SwitchDefaults.colors()
) {

    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp)
            .toggleable(
                value = checked,
                onValueChange = onCheckedChange,
                role = Role.Switch,
                enabled = enabled
            )
            .padding(horizontal = 16.dp)

    ) {
        CompositionLocalProvider(
            LocalContentAlpha provides
                    if (enabled) ContentAlpha.high else ContentAlpha.disabled
        ) {
            Text(
                text = label,
                style = MaterialTheme.typography.body1,
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .padding(end = 16.dp)
            )
        }

        Switch(
            checked = checked,
            onCheckedChange = null,
            enabled = enabled,
            colors = colors,
            modifier = Modifier.align(Alignment.CenterEnd)
        )
    }
}

@Composable
fun Example2() {
    val offersReceiving = "Recibir ofertas especiales"
    val offersReceivingState = remember { mutableStateOf(true) }

    LabelledSwitch(
        checked = offersReceivingState.value,
        label = offersReceiving,
        onCheckedChange = { offersReceivingState.value = it }
    )
}

@Preview
@Composable
fun Example2Preview() {
    SurfaceForPreview(
        modifier = Modifier
    ) {

        Example2()
    }
}
