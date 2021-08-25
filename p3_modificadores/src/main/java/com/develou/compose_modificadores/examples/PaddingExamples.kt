package com.develou.compose_modificadores.examples

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.develou.compose_modificadores.blue
import com.develou.compose_modificadores.yellow

@Composable
@Preview
fun PaddingExample1() {
    Box(Modifier.background(blue)) {
        Text(
            "Top = 32dp y Start = 32dp",
            modifier = Modifier
                .padding(top = 32.dp, start = 32.dp)
                .background(yellow)
        )

    }
}

@Composable
@Preview
fun PaddingExample2() {
    Box(Modifier.background(blue)) {
        Text(
            "Horizontal = 32dp",
            modifier = Modifier
                .padding(horizontal = 32.dp)
                .background(yellow)
        )
    }

}

@Composable
@Preview
fun PaddingExample3() {
    Box(Modifier.background(blue)) {
        Text(
            "All = 32dp",
            modifier = Modifier
                .padding(32.dp)
                .background(yellow)
        )
    }

}

@Composable
@Preview
fun PaddingExample4() {
    Box(Modifier.background(blue)) {
        Text(
            "Baseline = 32dp",
            modifier = Modifier
                .paddingFromBaseline(top = 32.dp)
                .background(yellow)
        )
    }
}