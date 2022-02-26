package com.develou.compose_componentes.examples.Switch

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.Switch
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.develou.compose_componentes.examples.RadioButton.SurfaceForPreview

@Composable
fun SimpleSwitch() {
    val isOn = remember { mutableStateOf(true) }

    Switch(
        checked = isOn.value,
        onCheckedChange = { newState -> isOn.value = newState }
    )
}

@Composable
fun Example1() {
    Box(Modifier.fillMaxSize()) {
        SimpleSwitch()
    }
}

@Preview
@Composable
fun Example1Preview() {
    SurfaceForPreview(
        modifier = Modifier
            .width(100.dp)
            .height(50.dp)
    ) {
        Example1()
    }
}
