package com.develou.compose_gestos.examples

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.rememberTransformableState
import androidx.compose.foundation.gestures.transformable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun RotationExample() {
    var rotation by remember {
        mutableStateOf(0f)
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .rotate(rotation)
                .transformable(
                    state = rememberTransformableState { _, _, degrees ->
                        rotation += degrees
                    })
                .size(150.dp, 300.dp)
                .background(Color.Red)
        )
    }
}