package com.develou.compose_layouts

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
@Preview
fun BoxesExample1() {
    Box(Modifier.size(200.dp)) {
        Text("A", modifier = aModifier(150))
        Text("B", modifier = bModifier(100))
        Text("C", modifier = cModifier(50))
    }
}

@Composable
@Preview
fun BoxesExample2() {
    Box(Modifier.size(200.dp), contentAlignment = Alignment.BottomCenter) {
        Text("C", modifier = cModifier(150))
        Text("B", modifier = bModifier(100))
        Text("A", modifier = aModifier(50))
    }
}

@Composable
@Preview
fun BoxesExample3() {
    Box(Modifier.size(200.dp)) {
        Text("A", modifier = aModifier(50).align(Alignment.TopCenter))
        Text("B", modifier = bModifier(50).align(Alignment.CenterStart))
        Text("C", modifier = cModifier(50).align(Alignment.BottomEnd))
    }
}