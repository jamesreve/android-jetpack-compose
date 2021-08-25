package com.develou.compose_gestos.examples

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.random.Random

@Composable
@Preview
fun ClickableExample() {
    var background by remember {
        mutableStateOf(Color.Blue)
    }
    Box(
        Modifier
            .background(background)
            .size(150.dp)
            .clickable {
                background = randomColor()
            }
    )
}

fun randomColor() = Color(Random.nextLong(0xFFFFFFFF))

@ExperimentalFoundationApi
@Composable
fun CombinedClickableExample() {
    var text by remember {
        mutableStateOf("Ninguno")
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            text = "Evento: $text",
            Modifier
                .combinedClickable(
                    onDoubleClick = {
                        text = "Double tap"
                    },
                    onLongClick = {
                        text = "Long press"
                    },
                    onClick = {
                        text = "Tap"
                    }),
            fontSize = 24.sp
        )
    }
}