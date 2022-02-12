package com.develou.compose_componentes.examples.TextField

import androidx.compose.foundation.border
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.ZeroCornerSize
import androidx.compose.material.ContentAlpha
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import com.develou.compose_componentes.R

@Composable
fun TextFieldStyleExample() {
    var nameOnCard by remember {
        mutableStateOf("Américo Vespucio")
    }

    val fontFamily = FontFamily(Font(R.font.playfairdisplay_regular))
    val color = Color(0xFF120524)
    val shape = CutCornerShape(ZeroCornerSize)

    TextField(
        value = nameOnCard,
        onValueChange = { nameOnCard = it },
        label = { Text("Nombre en la tarjeta") },
        textStyle = TextStyle(fontFamily = fontFamily),
        colors = TextFieldDefaults.textFieldColors(
            textColor = color,
            backgroundColor = Color.White,
            focusedLabelColor = color.copy(alpha = ContentAlpha.high),
            focusedIndicatorColor = Color.Transparent,
            cursorColor = color,
        ),
        shape = shape,
        modifier = Modifier.border(1.dp, color)
    )
}