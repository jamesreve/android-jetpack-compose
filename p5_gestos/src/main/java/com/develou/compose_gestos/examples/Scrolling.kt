package com.develou.compose_gestos.examples

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun HorizontalScrollExample() {
    val scrollState = rememberScrollState()
    Row(
        Modifier
            .fillMaxWidth()
            .horizontalScroll(scrollState)
    ) {
        repeat(10) {
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .background(randomColor())
            )

        }
    }
}

@Composable
fun VerticalScrollExample() {
    val scrollState = rememberScrollState()

    Column(
        Modifier
            .height(300.dp)
            .fillMaxWidth()
            .verticalScroll(scrollState),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        repeat(10) {
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .background(randomColor())
            )
        }
    }
}

@Composable
fun ScrollableExample() {
    val boxSize = 300f
    var scrollDeltaSum by remember {
        mutableStateOf(boxSize)
    }

    Column(
        Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Alpha = ${scrollDeltaSum / boxSize}")
        Box(
            modifier = Modifier
                .size(boxSize.dp)
                .scrollable(
                    orientation = Orientation.Vertical,
                    state = rememberScrollableState { delta ->
                        scrollDeltaSum = (scrollDeltaSum - delta / 2).coerceIn(0f, boxSize)
                        delta
                    }
                )
                .alpha(scrollDeltaSum / boxSize)
                .background(Color.Magenta)
        )
    }
}

@Preview
@Composable
fun NestedScrollExample() {
    Row(
        Modifier
            .fillMaxWidth()
            .height(100.dp)
            .horizontalScroll(rememberScrollState())
    ) {

        repeat(5) {
            Column(
                Modifier
                    .size(100.dp)
                    .background(randomColor())
                    .verticalScroll(rememberScrollState())
            ) {
                repeat(5) {
                    Text(
                        "Vertical",
                        Modifier.padding(16.dp)
                    )
                }

            }
        }
    }
}