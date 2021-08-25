package com.develou.compose_modificadores.examples

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.develou.compose_modificadores.blue
import com.develou.compose_modificadores.red
import com.develou.compose_modificadores.yellow

@Composable
@Preview
fun ChainingExample() {
    Row {
        Box(
            Modifier
                .border(2.dp, red)
                .background(blue)
                .padding(16.dp)
                .background(yellow)
                .size(100.dp)
        )

        Box(
            Modifier
                .size(100.dp)
                .background(yellow)
                .border(2.dp, red)
                .padding(16.dp)
                .background(blue)

        )
    }
}