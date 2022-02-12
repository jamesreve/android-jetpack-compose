package com.develou.compose_componentes.examples.FloatingActionButton

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.shape.ZeroCornerSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.*
import com.develou.compose_componentes.R

@Composable
fun FABShapeExample() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        FloatingActionButton(onClick = {}, shape = CutCornerShape(50.dp)) {
            Icon(imageVector = Icons.Default.Edit, contentDescription = "Editar")
        }

        Spacer(Modifier.size(16.dp))

        FloatingActionButton(onClick = {}, shape = CutCornerShape(4.dp)) {
            Icon(imageVector = Icons.Default.Star, contentDescription = "Añadir a favoritos")
        }

        Spacer(Modifier.size(16.dp))

        ExtendedFloatingActionButton(text = { Text("ADJUNTAR") },
            onClick = { },
            shape = RoundedCornerShape(
                ZeroCornerSize
            ),
            icon = {
                Icon(
                    painter = painterResource(R.drawable.ic_attachment),
                    contentDescription = "Adjuntar"
                )
            }
        )
    }
}

@Composable
fun FABColorsExample() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        FloatingActionButton(
            onClick = {}, backgroundColor = Color(0xFFFFA726),
            contentColor = Color.White
        ) {
            Icon(
                imageVector = Icons.Default.ShoppingCart,
                contentDescription = "Añadir a carrito"
            )
        }

        Spacer(Modifier.size(16.dp))

        ExtendedFloatingActionButton(
            text = { Text("AGENDAR") },
            onClick = { },
            backgroundColor = Color(0xFFBBDEFB),
            contentColor = Color(0xFF0D47A1)
        )
    }
}

@ExperimentalUnitApi
@Composable
fun FABTypographyExample() {
    ExtendedFloatingActionButton(
        text = {
            val nunitoFontFamily = FontFamily(Font(R.font.nunito_bold, FontWeight.Bold))
            val style = MaterialTheme.typography.button.copy(
                fontFamily = nunitoFontFamily,
                fontSize = 13.sp,
                letterSpacing = TextUnit(1.25f, TextUnitType.Sp)
            )
            Text("GUARDAR", style = style)
        },
        icon = {
            Icon(
                painter = painterResource(R.drawable.ic_save),
                contentDescription = "Guardar cambios"
            )
        },
        onClick = { }
    )
}