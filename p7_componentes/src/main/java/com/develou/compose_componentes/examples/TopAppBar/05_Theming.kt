package com.develou.compose_componentes.examples.TopAppBar

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp
import com.develou.compose_componentes.R

private val Besley = FontFamily(Font(R.font.besley_medium))

@Composable
internal fun ThemedTopAppBar() {

    MaterialTheme(
        colors = MaterialTheme.colors.copy(
            primary = Color(0xFFFFF8E1),
            onPrimary = Color(0xFF3e2723),
            primaryVariant = Color(0xFFFFF8E1)
        ),
        typography = MaterialTheme.typography.copy(
            h6 = TextStyle(fontFamily = Besley, fontSize = 21.sp)
        )
    ) {
        DetailTopAppBar()
    }
}