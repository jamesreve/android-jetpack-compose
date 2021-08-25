package com.develou.compose_modificadores.examples

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.develou.compose_modificadores.blue
import com.develou.compose_modificadores.green
import com.develou.compose_modificadores.red
import com.develou.compose_modificadores.yellow

@Composable
@Preview
fun BorderExamples() {
    Column {

        Box(
            Modifier
                .size(100.dp)
                .border(3.dp, Color.DarkGray)
        )

        Box(
            Modifier
                .size(100.dp)
                .border(
                    border = BorderStroke(3.dp, green),
                    shape = CutCornerShape(5.dp)
                )
        )

        Box(
            Modifier
                .size(100.dp)
                .border(
                    width = 3.dp,
                    brush = Brush.horizontalGradient(
                        listOf(yellow, blue, red)
                    ),
                    shape = RectangleShape
                )
        )
    }
}