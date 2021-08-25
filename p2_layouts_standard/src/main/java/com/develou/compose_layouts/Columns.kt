package com.develou.compose_layouts

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
@Preview
fun ColumnsExample1() {
    Column(Modifier.size(200.dp)) {
        Text("A", aModifier(50))
        Text("B", bModifier(50))
        Text("C", cModifier(50))
    }
}

@Composable
@Preview
fun ColumnsExample2() {
    Column(
        Modifier.size(200.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("A", aModifier(50))
        Text("B", bModifier(50))
        Text("C", cModifier(50))
    }
}

@Composable
@Preview
fun ColumnsExample3() {
    Column(
        Modifier.size(200.dp)
    ) {
        Text("A", modifier = aModifier(50))
        Text("B", modifier = bModifier(50).align(Alignment.CenterHorizontally))
        Text("C", modifier = cModifier(50).align(Alignment.End))
    }
}

@Composable
@Preview
fun ColumnsExample4() {
    Column(
        Modifier.size(200.dp)
    ) {
        Text("A", modifier = aModifier(50).weight(1.0f))
        Text("B", modifier = bModifier(50).weight(2.0f))
        Text("C", modifier = cModifier(50).weight(3.0f))
    }
}