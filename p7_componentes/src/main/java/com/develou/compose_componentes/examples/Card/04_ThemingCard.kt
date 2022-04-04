package com.develou.compose_componentes.examples.Card

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.develou.compose_componentes.R

@Composable
fun ThemingCard() {
    val Besley = FontFamily(Font(R.font.besley_medium))

    Box(modifier = Modifier.padding(16.dp)) {

        MaterialTheme(
            colors = MaterialTheme.colors.copy(
                surface = Color(0xFFFFF8E1),
                onSurface = Color(0xFF3e2723)
            ),
            typography = MaterialTheme.typography.copy(
                h6 = TextStyle(fontFamily = Besley, fontSize = 21.sp),
                body1 = TextStyle(fontFamily = Besley, fontSize = 16.sp),
                body2 = TextStyle(fontFamily = Besley, fontSize = 14.sp),
                button = TextStyle(fontFamily = Besley, fontSize = 14.sp)
            ),
            shapes = MaterialTheme.shapes.copy(medium = RoundedCornerShape(0))
        ) {
            StandardCard(elevation = 4.dp)
        }
    }
}