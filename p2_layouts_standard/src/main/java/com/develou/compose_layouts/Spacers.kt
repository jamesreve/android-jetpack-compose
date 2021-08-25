package com.develou.compose_layouts

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
@Preview
fun SpacersExample() {

    Column(Modifier.size(200.dp)) {
        Text("A", modifier = aModifier(50))
        Spacer(Modifier.size(100.dp, 10.dp))
        Text("B", modifier = bModifier(50))
        Spacer(Modifier.size(40.dp))
        Text("C", modifier = cModifier(50))
    }
}