package com.develou.compose_layouts

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
@Preview
fun RowsExample1() {
    Row(Modifier.size(200.dp)) {
        Text("A", modifier = aModifier(50))
        Text("B", modifier = bModifier(50))
        Text("C", modifier = cModifier(50))
    }
}

@Composable
@Preview
fun RowsExample2() {
    Row(Modifier.size(200.dp)) {
        Text("A", modifier = aModifier(50).weight(2.0f))
        Text("B", modifier = bModifier(50).weight(5.0f))
        Text("C", modifier = cModifier(50).weight(8.0f))
    }
}

@Composable
@Preview
fun RowsExample3() {
    Row(
        Modifier.size(200.dp),
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.Center
    ) {
        Text("A", modifier = aModifier(50))
        Text("B", modifier = bModifier(50))
        Text("C", modifier = cModifier(50))
    }
}

@Composable
@Preview
fun RowsExample4() {
    Row(Modifier.size(200.dp)) {
        Text("A", modifier = aModifier(50))
        Text("B", modifier = aModifier(50).align(Alignment.CenterVertically))
        Text("C", modifier = bModifier(50).align(Alignment.Bottom))
    }
}