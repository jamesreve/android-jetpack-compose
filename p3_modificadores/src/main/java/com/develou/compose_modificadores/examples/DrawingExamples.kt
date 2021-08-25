package com.develou.compose_modificadores.examples

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.develou.compose_modificadores.blue
import com.develou.compose_modificadores.green
import com.develou.compose_modificadores.red
import com.develou.compose_modificadores.yellow

@Composable
@Preview
fun AlphaExample() {
    Box(Modifier.size(150.dp, 100.dp)) {
        Box(
            Modifier
                .size(100.dp)
                .alpha(0.5f)
                .background(blue, CircleShape)
                .border(2.dp, blue, CircleShape)
        )
        Box(
            Modifier
                .size(100.dp)
                .alpha(0.5f)
                .background(red, CircleShape)
                .border(2.dp, red, CircleShape)
                .align(Alignment.CenterEnd)
        )
    }
}

val brush = Brush.horizontalGradient(
    listOf(green, red)
)

@Composable
@Preview
fun BackgroundExample() {
    Column {
        Box(
            Modifier
                .size(100.dp)
                .background(yellow)
        )
        Box(
            Modifier
                .size(100.dp)
                .background(brush = brush)
        )
    }
}

@Composable
@Preview
fun ClipExample() {
    Row(Modifier.padding(16.dp)) {
        Column {
            Box(
                Modifier
                    .size(100.dp)
                    .clip(CircleShape)
                    .background(blue)

            )

            Box(
                Modifier
                    .padding(vertical = 29.dp)
                    .size(100.dp, 50.dp)
                    .clip(RoundedCornerShape(50))
                    .background(blue)

            )
            Box(
                Modifier
                    .size(100.dp)
                    .clip(RoundedCornerShape(topStart = 50.dp))
                    .background(blue)

            )

        }
        Spacer(Modifier.size(8.dp))
        Column {
            Box(
                Modifier
                    .size(100.dp)
                    .clip(RectangleShape)
                    .background(blue)

            )

            Box(
                Modifier
                    .padding(vertical = 4.dp)
                    .size(100.dp)
                    .clip(CutCornerShape(50))
                    .background(blue)

            )
            Box(
                Modifier
                    .size(100.dp)
                    .clip(CutCornerShape(topEnd = 25.dp))
                    .background(blue)

            )
        }
    }

}