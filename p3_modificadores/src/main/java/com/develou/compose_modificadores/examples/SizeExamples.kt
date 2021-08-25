package com.develou.compose_modificadores.examples

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.develou.compose_modificadores.blue
import com.develou.compose_modificadores.green
import com.develou.compose_modificadores.red
import com.develou.compose_modificadores.yellow

@Composable
@Preview
fun WidthExample() {
    Column(
        Modifier.width(300.dp)
    ) {
        Text(
            "width() -> 100dp",
            Modifier
                .width(100.dp)
                .height(100.dp)
                .background(yellow)
        )
        Text(
            "fillMaxWidth() -> 300dp",
            Modifier
                .fillMaxWidth()
                .height(100.dp)
                .background(blue)
        )
        Text(
            "requiredWidth() -> 400dp",
            Modifier
                .requiredWidth(400.dp)
                .height(100.dp)
                .background(red)
        )
    }
}

@Composable
@Preview
fun HeightExamples() {
    Row(
        Modifier.height(300.dp)
    ) {
        Text(
            "100dp",
            Modifier
                .weight(1.0f)
                .height(100.dp)
                .background(yellow)
        )
        Text(
            "MAX",
            Modifier
                .weight(1.0f)
                .fillMaxHeight()
                .background(blue)
        )
        Text(
            "MAX/2",
            Modifier
                .weight(1.0f)
                .fillMaxHeight(0.5f)
                .background(red)
        )
        Text(
            "400dp",
            Modifier
                .weight(1.0f)
                .requiredHeight(400.dp)
                .background(green)
        )
    }
}

@Composable
@Preview
fun SizeExamples() {
    Box(Modifier.size(300.dp)) {
        Box(
            Modifier
                .fillMaxSize()
                .background(yellow)
        )
        Box(
            Modifier
                .size(50.dp)
                .align(Alignment.BottomCenter)
                .background(blue)
        )
        Box(
            Modifier
                .size(50.dp, 100.dp)
                .background(red)
        )
        Box(
            Modifier
                .requiredSize(100.dp)
                .align(Alignment.CenterEnd)
                .background(green)
        )
    }
}