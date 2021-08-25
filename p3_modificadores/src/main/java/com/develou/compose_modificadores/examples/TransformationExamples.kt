package com.develou.compose_modificadores.examples

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.develou.compose_modificadores.blue
import com.develou.compose_modificadores.red
import com.develou.compose_modificadores.yellow

@Composable
@Preview
fun ScaleExample() {
    val size = 100.dp
    Row(
        Modifier.size(400.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Box(
            Modifier
                .scale(0.5f)
                .size(size)
                .background(yellow)
        )
        Box(
            Modifier
                .scale(1f)
                .size(size)
                .background(blue)
        )
        Box(
            Modifier
                .scale(2f)
                .size(size)
                .background(red)
        )
    }
}

@Composable
@Preview
fun RotateExample() {
    Row(modifier = Modifier.padding(16.dp)) {
        RotableCircle(0f)
        RotableCircle(45f)
        RotableCircle(90f)
        RotableCircle(135f)
    }
}

@Composable
fun RotableCircle(degrees: Float) {
    Box(
        Modifier
            .rotate(degrees)
            .size(50.dp)
            .background(yellow, CircleShape)

    ) {
        Box(
            Modifier
                .size(15.dp)
                .background(blue, CircleShape)
                .align(Alignment.TopCenter)
        )
    }
}